// Custom exception class - extends Exception (checked exception)
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {

        // Case 1: Sufficient balance
        System.out.println("----- Case 1: Sufficient Balance -----");
        try {
            withdraw(5000, 2000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Case 2: Insufficient balance (triggers custom exception)
        System.out.println("\n----- Case 2: Insufficient Balance -----");
        try {
            withdraw(1000, 3000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt finished.");
        }
    }

    // Method that throws the custom exception
    static void withdraw(double balance, double amount) throws InsufficientBalanceException {
        System.out.println("Account balance: " + balance);
        System.out.println("Withdrawal amount: " + amount);

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance! Cannot withdraw " + amount + " from balance " + balance);
        }

        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

