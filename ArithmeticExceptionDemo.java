public class ArithmeticExceptionDemo {
    public static void main(String[] args) {
        int num1 = 50;
        int num2 = 0;

        System.out.println("Attempting to divide " + num1 + " by " + num2);

        try {
            int result = num1 / num2;  // This will throw ArithmeticException
            System.out.println("Result: " + result);  // Never executed

        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e);
            System.out.println("Message: " + e.getMessage());
            System.out.println("You cannot divide a number by zero.");

        } finally {
            System.out.println("Execution of try-catch block completed.");
        }

        System.out.println("Program continues after handling the exception...");
    }
}

