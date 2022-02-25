import java.util.Random;

public class counting_v2 {
    public static void main(String [] args) {
        try {
            long initial_time = System.nanoTime();
            int n = Integer.parseInt(args[0]);
            StringBuilder str = new StringBuilder();
            Random random = new Random();
            int counter = 0;
            // Get the index of the first appearance
            int index = -1;
            // Get the times that the word IPN appeared
            int times = 0;
            for (int i = 0; i < n * 4; i++) {
                // Add a space
                if (counter > 2) {
                    // Count the length of the current word
                    counter = 0;
                    // The ASCII value of whitespace is 32
                    str.append((char)32);
                } else {
                    // The ASCII value of A is 65 
                    str.append((char) (random.nextInt(26) + 65));
                    counter++;
                }
            }
            /*
                ASCII Values
                I -> 73
                P -> 80
                N -> 78
            */
            for (int i = 0; i < n * 4; i += 4) {
                // Check if the current subarray contains the bytes that belong to the word IPN
                if (Character.compare(str.charAt(i), (char) 'I') == 0 && Character.compare(str.charAt(i+1), (char) 'P') == 0 && Character.compare(str.charAt(i+2), (char) 'N') == 0) {
                    times += 1;
                }
            }
            // Getting the index of the first IPN ocurrance if it exists
            index = str.indexOf("IPN");
            // Getting the execution time in nano seconds
            System.out.printf("Execution time in nanoseconds: %d\n", (System.nanoTime() - initial_time));
            System.out.printf("Times that the word IPN appeared: %d\n", times);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
