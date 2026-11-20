public class MultipleCatchDemo {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};

        // Case 1: ArithmeticException
        System.out.println("----- Case 1 -----");
        processArray(numbers, 1, 0);

        // Case 2: ArrayIndexOutOfBoundsException
        System.out.println("\n----- Case 2 -----");
        processArray(numbers, 5, 2);

        // Case 3: NumberFormatException
        System.out.println("\n----- Case 3 -----");
        convertStringToInt("abc123");

        // Case 4: No exception
        System.out.println("\n----- Case 4 -----");
        processArray(numbers, 2, 5);
    }

    static void processArray(int[] arr, int index, int divisor) {
        try {
            System.out.println("Accessing arr[" + index + "] and dividing by " + divisor);
            int value = arr[index] / divisor;
            System.out.println("Result: " + value);

        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("General Exception caught: " + e.getMessage());

        } finally {
            System.out.println("Finally block executed for processArray().");
        }
    }

    static void convertStringToInt(String str) {
        try {
            System.out.println("Converting \"" + str + "\" to integer...");
            int num = Integer.parseInt(str);
            System.out.println("Converted number: " + num);

        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());

        } finally {
            System.out.println("Finally block executed for convertStringToInt().");
        }
    }
}
