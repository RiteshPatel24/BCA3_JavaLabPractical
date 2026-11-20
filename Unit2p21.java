// Encapsulated class - fields are private, accessed only via public getters/setters
class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter methods
    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Setter method with validation logic
    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        } else {
            System.out.println("Invalid name. Update rejected.");
        }
    }

    // Controlled behavior instead of a plain setter for balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal rejected.");
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
        }
    }

    void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// Main class to test encapsulation
public class EncapsulationDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Priya Sharma", "ACC10023", 1000.0);

        System.out.println("--- Initial Account Info ---");
        account.displayAccountInfo();

        System.out.println("\n--- Performing Transactions ---");
        account.deposit(500.0);
        account.withdraw(2000.0);   // exceeds balance, rejected
        account.withdraw(300.0);
        account.deposit(-50.0);     // invalid amount, rejected

        System.out.println("\n--- Updating Account Holder Name ---");
        account.setAccountHolder("");           // invalid, rejected
        account.setAccountHolder("Priya P. Sharma"); // valid

        System.out.println("\n--- Final Account Info ---");
        account.displayAccountInfo();

        // Direct field access is NOT possible - this would cause a compile error:
        // account.balance = 100000;  // balance is private
    }
}
