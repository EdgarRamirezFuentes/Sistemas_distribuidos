/*
    Name: Ejercicio3.java
    Author: Edgar Alejandro Ramirez Fuentes
    Description: 
    This program transforms seconds to a format H:M:S
*/
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        int seconds = 0;
        Scanner scn = new Scanner(System.in);
        try {
            System.out.println("seconds: ");
            seconds = scn.nextInt();
            if (seconds < 0) {
                scn.close();
                throw new Exception("The value must be greater or equal than 0");
            }
            // Getting the number of minutes based on the seconds
            int minutes = (int) seconds / 60;
            // Getting the hours based on the minutes
            int hours = (int) minutes / 60;
            // Getting the remaining minutes of the hours
            minutes %= 60;
            // Gettings the seconds remaining seconds
            int remaining_seconds = seconds % 60;
            String result = seconds + " seconds are equal to " + hours + ((hours > 1 || hours == 0) ? " hours, " : " hour, ") + 
            minutes + ((minutes > 1 || minutes == 0) ? " minutes, and  " : " minute, and ") +  
            remaining_seconds + ((remaining_seconds > 1 || remaining_seconds == 0) ? " seconds." : " second.");
            System.out.println(result);
            scn.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
