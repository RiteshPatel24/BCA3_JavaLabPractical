public class FinallyBlockDemo {
    public static void main(String[] args) {

        // Case 1: Exception occurs
        System.out.println("----- Case 1: Exception Occurs -----");
        divide(20, 0);

        // Case 2: No exception occurs
        System.out.println("\n----- Case 2: No Exception Occurs -----");
        divide(20, 4);
    }

    static void divide(int a, int b) {
        try {
            System.out.println("Trying to divide " + a + " by " + b);
            int result = a / b;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());

        } finally {
            System.out.println("Finally block executed — runs no matter what.");
        }
    }
}
