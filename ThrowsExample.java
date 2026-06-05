import java.io.*;

public class ThrowsExample {

    // Method declares it may throw IOException using 'throws'
    static void readFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);  // May throw FileNotFoundException
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    // Method declares multiple exceptions
    static void riskyMethod(int choice) throws ArithmeticException, ArrayIndexOutOfBoundsException {
        if (choice == 1) {
            int result = 10 / 0;  // ArithmeticException
        } else if (choice == 2) {
            int[] arr = new int[3];
            System.out.println(arr[10]);  // ArrayIndexOutOfBoundsException
        } else {
            System.out.println("No exception for choice: " + choice);
        }
    }

    // Chained throws - calling a method that throws
    static void callRiskyMethod() throws ArithmeticException {
        int result = 5 / 0;
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Handle IOException from readFile
        try {
            readFile("test.txt");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }

        // Handle ArithmeticException
        try {
            riskyMethod(1);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // Handle ArrayIndexOutOfBoundsException
        try {
            riskyMethod(2);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // No exception
        try {
            riskyMethod(3);
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
