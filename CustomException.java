// Step 1: Create a custom checked exception
class InsufficientBalanceException extends Exception {
    private double amount;

    public InsufficientBalanceException(double amount) {
        super("Insufficient balance! Short by: ₹" + amount);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

// Step 2: Create a custom unchecked exception
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Step 3: Use the custom exceptions in a BankAccount class
class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited ₹" + amount + " | New Balance: ₹" + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(amount - balance);
        }
        balance -= amount;
        System.out.println("Withdrawn ₹" + amount + " | Remaining Balance: ₹" + balance);
    }

    public double getBalance() {
        return balance;
    }
}

// Step 4: Main class
public class CustomException {

    static void registerUser(String name, int age) {
        if (age < 18) {
            throw new InvalidAgeException("User '" + name + "' must be 18+. Provided age: " + age);
        }
        System.out.println("User registered: " + name + " (Age: " + age + ")");
    }

    public static void main(String[] args) {
        // Test BankAccount with custom checked exception
        BankAccount account = new BankAccount("Ravi", 5000.0);

        try {
            account.deposit(2000);
            account.withdraw(3000);
            account.withdraw(6000);  // This will throw InsufficientBalanceException
        } catch (InsufficientBalanceException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
            System.out.println("Amount short: ₹" + e.getAmount());
        }

        System.out.println("---");

        // Test custom unchecked exception
        try {
            registerUser("Amit", 20);   // Valid
            registerUser("Rahul", 15);  // Will throw InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Custom RuntimeException Caught: " + e.getMessage());
        }

        System.out.println("---");

        // Finally block with custom exception
        try {
            account.withdraw(100);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction complete. Final Balance: ₹" + account.getBalance());
        }
    }
}
