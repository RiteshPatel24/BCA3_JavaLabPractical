public class ExceptionDemo {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        try {
            System.out.println("Accessing array element...");
            int result = numbers[1] / 0;  // Will throw ArithmeticException
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
            System.out.println("Exception message: " + e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds!");

        } finally {
            System.out.println("This block always executes, regardless of exception.");
        }

        System.out.println("Program continues after exception handling...");
    }
}
