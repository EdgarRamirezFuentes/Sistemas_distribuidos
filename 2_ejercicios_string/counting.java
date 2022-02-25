import java.util.Random;

public class counting {
    public static void main(String[] args){
        try {
            long initial_time = System.nanoTime();
            int n = Integer.parseInt(args[0]);
            byte [] str = new byte[n*4];
            int counter = 0;
            // Get the index of the first appearance
            int index = -1;
            // Get the times that the word IPN appeared
            int times = 0;
            Random random = new Random();
            for (int i = 0; i < n * 4; i++) {
                // Add a space
                if (counter > 2) {
                    // Count the length of the current word
                    counter = 0;
                    // The ASCII value of whitespace is 32
                    str[i] = 32;
                } else {
                    // The ASCII value of A is 65 
                    str[i] = (byte) (random.nextInt(26) + 65);
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
                if (Byte.compare(str[i], (byte) 73) == 0 && (Byte.compare(str[i+1], (byte) 80) == 0 && (Byte.compare(str[i+2], (byte) 78)) == 0)) {
                    times += 1;
                    // Update the index only if it is the first appearance
                    if (index == -1) {
                        index = i;
                    }
                }
            }
            // Getting the execution time in nano seconds
            System.out.printf("Execution time in nanoseconds: %d\n", (System.nanoTime() - initial_time));
            System.out.printf("Times that the word IPN appeared: %d\n", times);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}