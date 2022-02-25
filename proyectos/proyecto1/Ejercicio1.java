/*
    Name: Ejercicio1.java
    Author: Edgar Alejandro Ramirez Fuentes
    Description: 
    This program calculates the Volume of a Cylinder and a Cone based on the radio and height of the figures.
*/
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double radio = 0, height = 0, cylinder_volume = 0, cone_volume = 0;
        try {
            // Getting the radio and height values
            System.out.println("Input the radio: ");
            radio = scn.nextDouble();
            System.out.println("Input the height: ");
            height = scn.nextDouble();
            if (radio <= 0 || height <= 0) {
                scn.close();
                throw new Exception("The values must be greater than 0");
            }
            // Calculating the cylindera and cone volume using the provided values
            cylinder_volume = Math.PI * Math.pow(radio, 2) * height;
            cone_volume = cylinder_volume / 3;
            // Displaying the results
            System.out.println("Cylinder Volume: " + String.format("%.4f", cylinder_volume));
            System.out.println("Cone Volume: " + String.format("%.4f", cone_volume));
        } catch(Exception e) {
            System.err.println(e);
        } 
    }
}