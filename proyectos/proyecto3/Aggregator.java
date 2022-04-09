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

import networking.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aggregator {
    private WebClient webClient;

    public Aggregator() {
        this.webClient = new WebClient();
    }

    public void sendTasksToWorkers(List<String> workersAddresses, String[] tasks) {
        CompletableFuture<String> futureWorker1 = new CompletableFuture<String>();
        CompletableFuture<String> futureWorker2 = new CompletableFuture<String>();
        CompletableFuture<String> futureWorker3 = new CompletableFuture<String>();

        int current_task = 0;
        int completed_tasks = 0;

        // Inicializamos las tareas
        futureWorker1 = webClient.sendTask(workersAddresses.get(0), tasks[0].getBytes()); current_task++;
        if (tasks.length > 1) { futureWorker2 = webClient.sendTask(workersAddresses.get(1), tasks[1].getBytes()); current_task++;} 
        if (tasks.length > 2) { futureWorker3 = webClient.sendTask(workersAddresses.get(2), tasks[2].getBytes()); current_task++;} 

        while(completed_tasks != tasks.length) {
            // Checa si el primer trabajador terminó su tarea
            if(futureWorker1.isDone()) { 
                try {
                    // Imprime la respuesta y aumenta las tareas terminadas
                    String responseMessage = futureWorker1.get();
                    System.out.println(responseMessage);
                    completed_tasks++;
                    // Realiza una tarea más, si aún hay tareas restantes
                    if (current_task < tasks.length){
                        futureWorker1 = webClient.sendTask(workersAddresses.get(0), tasks[current_task].getBytes());  
                        current_task++; 
                    } else {
                        // Si no hay tareas restantes, se actualiza a un futuro incompleto para no evaluar doble vez este trabajador
                        futureWorker1 = new CompletableFuture<String>().newIncompleteFuture();
                    }
                continue;
                } catch(Exception ex) {
                    System.out.println(ex);
                }
            }

            if(futureWorker2.isDone()) { 
                try {
                    // Imprime la respuesta y aumenta las tareas terminadas
                    String responseMessage = futureWorker2.get();
                    System.out.println(responseMessage);
                    completed_tasks++;
                    // Realiza una tarea más, si aún hay tareas restantes
                    if (current_task < tasks.length){
                        futureWorker2 = webClient.sendTask(workersAddresses.get(1), tasks[current_task].getBytes());  
                        current_task++; 
                    } else {
                        // Si no hay tareas restantes, se actualiza a un futuro incompleto para no evaluar doble vez este trabajador
                        futureWorker2 = new CompletableFuture<String>().newIncompleteFuture();
                    }
                continue;
                } catch(Exception ex) {
                    System.out.println(ex);
                }
            }

            if(futureWorker3.isDone()) {
                try {
                    // Imprime la respuesta y aumenta las tareas terminadas
                    String responseMessage = futureWorker3.get();
                    System.out.println(responseMessage);
                    completed_tasks++;
                    // Realiza una tarea más, si aún hay tareas restantes
                    if (current_task < tasks.length){
                        futureWorker3 = webClient.sendTask(workersAddresses.get(2), tasks[current_task].getBytes());  
                        current_task++; 
                    }else {
                        // Si no hay tareas restantes, se actualiza a un futuro incompleto para no evaluar doble vez este trabajador
                        futureWorker3 = new CompletableFuture<String>().newIncompleteFuture();
                    }
                continue;
                } catch(Exception ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}
