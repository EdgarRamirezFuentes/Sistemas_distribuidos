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

import java.util.Arrays;

public class Application {
    // Endpoints de los servidores
    private static String WORKER_ADDRESS_1 = "";
    private static String WORKER_ADDRESS_2 = "";
	private static String WORKER_ADDRESS_3 = "";

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Se deben introducir 3 direcciones ip y por lo menos 1 palabra a buscar");
            System.exit(1);
        }

        WORKER_ADDRESS_1 = args[0];
        WORKER_ADDRESS_2 = args[1];
        WORKER_ADDRESS_3 = args[2];
        Aggregator aggregator = new Aggregator();
        
        // Palabras a buscar
        String[] tasks = Arrays.copyOfRange(args, 3, args.length);
        
        // Enviamos los workers y las tareas
        aggregator.sendTasksToWorkers(Arrays.asList(WORKER_ADDRESS_1, WORKER_ADDRESS_2, WORKER_ADDRESS_3), tasks);
    }
}
