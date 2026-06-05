public class FinallyBlock {
    public static void main(String[] args) {
        // Example 1: finally executes even when exception occurs
        try {
            System.out.println("Inside try block");
            int result = 10 / 0;  // ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes!");
        }

        System.out.println("---");

        // Example 2: finally executes even without exception
        try {
            System.out.println("Try block - No exception here");
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed after normal flow.");
        }

        System.out.println("---");

        // Example 3: finally used for resource cleanup (simulated)
        try {
            System.out.println("Opening resource...");
            String[] data = {"Java", "Python", "C++"};
            System.out.println("Accessing: " + data[5]);  // Exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Index out of bounds - " + e.getMessage());
        } finally {
            System.out.println("Closing resource... (cleanup in finally)");
        }
    }
}
