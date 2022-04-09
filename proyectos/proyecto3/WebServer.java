/*
 *  MIT License
 *
 *  Copyright (c) 2019 Michael Pogrebinsky - Distributed Systems & Cloud Computing with Java
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

/**
 *  Nombre: Edgar Alejandro Ramírez Fuentes
 * Grupo: 4CM13
 * Proyecto 3
*/

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.io.FileInputStream;
import java.io.BufferedReader;  
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebServer {
        //Declaración de endpoints
        private static final String STATUS_ENDPOINT = "/status";
        private static final String SEARCH_ENDPOINT = "/search";

        //Puerto para realizar conexiones con clientes
        private final int port;

        //Implementando un servidor con la clase HttpServer
        private HttpServer server;

        public static void main(String[] args) {
                //Se coloca puerto por default en caso de que no se envíe por línea de comandos
                int serverPort = 8080;
                if (args.length == 1) {
                        serverPort = Integer.parseInt(args[0]);
                }

                //Instancia de WebServer
                WebServer webServer = new WebServer(serverPort);

                //Ejecutando método startServer para iniciar configuración del servidor
                webServer.startServer();

                System.out.println("Servidor escuchando en el puerto " + serverPort);
        }

        //Constructor
        public WebServer(int port) {
                this.port = port;
        }

        public void startServer() {
                try {
                        //Creando instancia de la clase HttpServer
                        //Recibe un socket y el tamaño de la lista de solicitudes pendientes para el servidor
                        //Al colocar un cero se deja la decisión al servidor
                        this.server = HttpServer.create(new InetSocketAddress(port), 0);
                } catch (IOException e) {
                        e.printStackTrace();
                        return;
                }

                //Creando objetos HttpContext
                HttpContext statusContext = server.createContext(STATUS_ENDPOINT);
                HttpContext searchContext = server.createContext(SEARCH_ENDPOINT);

                //Asigna un método manejador a los endpoints
                statusContext.setHandler(this::handleStatusCheckRequest);
                searchContext.setHandler(this::handleSearchRequest);

                //Se proveen 8 hilos para que el servidor trabaje
                server.setExecutor(Executors.newFixedThreadPool(8));

                //Se inicia el servidor como hilo en segundo plano
                server.start();
        }

        //Se analiza si la petición es GET para devolver que el servidor está vivo
        private void handleStatusCheckRequest(HttpExchange exchange) throws IOException {
                if (!exchange.getRequestMethod().equalsIgnoreCase("get")) {
                        exchange.close();
                        return;
                }

                String responseMessage = "El servidor está vivo\n";
                sendResponse(responseMessage.getBytes(), exchange);
        }

        private void sendResponse(byte[] responseBytes, HttpExchange exchange) throws IOException {
                //Agrega estatus code 200 de éxito y longitud de la respuesta
                exchange.sendResponseHeaders(200, responseBytes.length);

                //Se escribe en el cuerpo del mensaje
                OutputStream outputStream = exchange.getResponseBody();

                //Se envía al cliente por medio del Stream
                outputStream.write(responseBytes);
                outputStream.flush();
                outputStream.close();
                exchange.close();
        }

        //Manejador del endpoint search
        private void handleSearchRequest(HttpExchange exchange) throws IOException {
                //Se verifica si se solicitó un método POST
                if (!exchange.getRequestMethod().equalsIgnoreCase("post")) {
                        exchange.close();
                        return;
                }

                //Se busca clave X-Debug para verificar estado del servidor
                Headers headers = exchange.getRequestHeaders();
                boolean isDebugMode = headers.containsKey("X-Debug") && headers.get("X-Debug").get(0).equalsIgnoreCase("true") ? true : false;

                //Calculando tiempo que tardó el proceso completo
                long startTime = System.nanoTime();

                //Se recupera el cuerpo del mensaje de la transacción HTTP
                //Este va a contener la cantidad de tokens aleatorios
                byte[] requestBytes = exchange.getRequestBody().readAllBytes();

                //Se envían los números recibidos para calcular una operación con calculateResponse
                byte[] responseBytes = calculateSearchResponse(requestBytes);

                //Se termina el cálculo y se toma el tiempo final
                long finishTime = System.nanoTime();

                //Si se activó el modo Debug se imprime el tiempo que tardó
                if (isDebugMode) {
                        String debugMessage = String.format("La operacion tomo %d nanosegundos", finishTime - startTime);
                        //Se coloca el tiempo en el header X-Debug-Info
                        exchange.getResponseHeaders().put("X-Debug-Info", Arrays.asList(debugMessage));
                }

                //Se envía respuesta al cliente
                sendResponse(responseBytes, exchange);
        }


        //Método para buscar cadena en tokens de cadenota
        private byte[] calculateSearchResponse(byte[] requestBytes) {
                try {
                        // Obtieniedo la palabra a buscar
                        String word = new String(requestBytes);
                        int times = 0;

                        // Definimos la palabra como regex
                        Pattern pattern = Pattern.compile(word, Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
                        Matcher matcher;

                        String string = ""; 
                        // Leemos el contenido del archivo línea por línea
                        FileInputStream is = new FileInputStream("./BIBLIA_COMPLETA.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                        while((string = br.readLine()) != null) {
                                // Actualizamos el texto en el que se va a buscar la palabra
                                matcher = pattern.matcher(string);
                                // Buscamos el número de ocurrencias de la palabra en la línea de texto
                                while(matcher.find()) times++;
                        }
                        br.close(); 
                        System.out.printf("Llega la palabra: %s y se contaron %d ocurrencias.\n", word, times);
                        return String.format("\nPalabra: %s Ocurrencias: %d\n", word, times).getBytes();
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return String.format("Ocurrió un error en el servidor!!!").getBytes();
        }

}