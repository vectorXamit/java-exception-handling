public class ThrowExample {

    // Method that throws an exception manually
    static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Access denied - Age must be 18 or above. Your age: " + age);
        } else {
            System.out.println("Access granted. Welcome!");
        }
    }

    // Method that throws NullPointerException manually
    static void checkName(String name) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null!");
        }
        System.out.println("Hello, " + name + "!");
    }

    // Method that throws IllegalArgumentException
    static void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Invalid marks: " + marks + ". Marks must be between 0 and 100.");
        }
        System.out.println("Marks set to: " + marks);
    }

    public static void main(String[] args) {
        // Test checkAge
        try {
            checkAge(15);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Test checkName
        try {
            checkName(null);
        } catch (NullPointerException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Test setMarks - invalid
        try {
            setMarks(110);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Test setMarks - valid
        setMarks(85);
    }
}
