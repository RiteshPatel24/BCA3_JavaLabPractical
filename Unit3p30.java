public class ExceptionChainingDemo {
    public static void main(String[] args) {
        System.out.println("----- Program Start -----");
        try {
            processOrder();
        } catch (OrderProcessingException e) {
            System.out.println("\nException caught in main(): " + e.getMessage());

            // Access the original (root) cause of the exception
            Throwable cause = e.getCause();
            System.out.println("Caused by: " + cause);

            System.out.println("\n----- Full Stack Trace -----");
            e.printStackTrace();
        }
        System.out.println("\n----- Program End -----");
    }

    static void processOrder() throws OrderProcessingException {
        try {
            System.out.println("Processing order...");
            calculateTotal(1000, 0);  // will cause ArithmeticException

        } catch (ArithmeticException e) {
            // Wrap the original exception inside a new custom exception (chaining)
            throw new OrderProcessingException("Order processing failed due to a calculation error", e);
        }
    }

    static double calculateTotal(double amount, int quantity) {
        System.out.println("Calculating total for amount: " + amount + ", quantity: " + quantity);
        return amount / quantity;  // ArithmeticException: division by zero
    }
}

// Custom exception that supports chaining via the (message, cause) constructor
class OrderProcessingException extends Exception {
    public OrderProcessingException(String message, Throwable cause) {
        super(message, cause);  // passes the original exception as the "cause"
    }
}
