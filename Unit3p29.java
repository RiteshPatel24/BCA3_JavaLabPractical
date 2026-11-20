public class ExceptionPropagationDemo {
    public static void main(String[] args) {
        System.out.println("----- Program Start -----");
        try {
            methodA();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in main(): " + e.getMessage());
        }
        System.out.println("----- Program End -----");
    }

    // Level 1: calls methodB, does not handle the exception
    static void methodA() {
        System.out.println("Inside methodA() - calling methodB()");
        methodB();
        System.out.println("This line in methodA() will NOT execute if exception propagates");
    }

    // Level 2: calls methodC, does not handle the exception
    static void methodB() {
        System.out.println("Inside methodB() - calling methodC()");
        methodC();
        System.out.println("This line in methodB() will NOT execute if exception propagates");
    }

    // Level 3: exception actually occurs here
    static void methodC() {
        System.out.println("Inside methodC() - performing division");
        int result = 10 / 0;  // ArithmeticException occurs here
        System.out.println("Result: " + result);  // Never executed
    }
}
