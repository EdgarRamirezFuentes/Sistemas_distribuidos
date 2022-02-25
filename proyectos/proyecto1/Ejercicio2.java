/*
    Name: Ejercicio2.java
    Author: Edgar Alejandro Ramirez Fuentes
    Description: 
    This program calculates the area of a trapeze based on the size of its sides "a" and "b", and its height.
*/
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        double side_a = 0, side_b = 0, height = 0, trapeze_area = 0;
        Scanner scn = new Scanner(System.in);
        try {
            // Getting the a, b, and h values
            System.out.println("Side a: ");
            side_a = scn.nextDouble();
            System.out.println("Side b: ");
            side_b = scn.nextDouble();
            System.out.println("Height: ");
            height = scn.nextDouble();

            if (side_a <= 0 || side_b <= 0 || height <= 0) {
                scn.close();
                throw new Exception("The values must be greater than 0");
            }

            // Calculating the area
            trapeze_area = ((side_a + side_b) / 2) * height;

            // Displaying the result
            System.out.println(String.format("Trapeze area: %.4f" , trapeze_area));
            scn.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
