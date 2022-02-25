/*
    Name: Ejercicio5.java
    Author: Edgar Alejandro Ramirez Fuentes
    Description: 
    This program calculates the values of x, represented in decimal format, that belongs to ax^2 + bx + c = 0.
*/ 


import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        int grade = 0;
        Scanner scn = new Scanner(System.in);
        try {
            System.out.println("Grade: ");
            grade = scn.nextInt();
            if (grade < 0 || grade > 100) {
                scn.close();
                throw new Exception("The grade must be in the range 0-100");
            }

            if (grade >= 90) {
                grade = "A";
            } else if (grade >= 80) {

            } else if (grade >= 60) {

            } else {

            }
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}
