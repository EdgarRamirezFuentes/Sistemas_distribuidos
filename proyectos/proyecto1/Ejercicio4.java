/*
    Name: Ejercicio4.java
    Author: Edgar Alejandro Ramirez Fuentes
    Description: 
    This program calculates the values of x, represented in decimal format, that belongs to ax^2 + bx + c = 0.
*/

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        double a = 0, b = 0, c = 0, x1 = 0, x2 = 0;
        Scanner scn = new Scanner(System.in);
        try {
            System.out.println("a: ");
            a = scn.nextDouble();
            System.out.println("b: ");
            b = scn.nextDouble();
            System.out.println("c: ");
            c = scn.nextDouble();

            // If this happens, the equation cannot be solved
            if ((Math.pow(b, 2) - (4 * a * c)) < 0) {
                scn.close();
                throw new Exception("This equation has no a real solution");
            } else if (a == 0) {
                scn.close();
                throw new Exception("The value of a cannot be 0");
            }

            // Using the general formula to calculate the values of x
            x1 = (-b + Math.sqrt( Math.pow(b, 2) - (4 * a * c) )) / (2 * a);
            x2 = (-b - Math.sqrt( Math.pow(b, 2) - (4 * a * c) )) / (2 * a);

            System.out.println("The solutions to this equation are: ");
            System.out.println("X1: " + String.format("%.4f", x1));
            System.out.println("X2: " + String.format("%.4f", x2));
            
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}
