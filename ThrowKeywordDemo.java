public class ThrowKeywordDemo {
    public static void main(String[] args) {

        // Case 1: Valid age
        System.out.println("----- Case 1: Valid Age -----");
        checkEligibility(20);

        // Case 2: Invalid age (triggers throw)
        System.out.println("\n----- Case 2: Invalid Age -----");
        checkEligibility(15);
    }

    static void checkEligibility(int age) {
        try {
            System.out.println("Checking eligibility for age: " + age);
            validateAge(age);
            System.out.println("Eligible to vote.");

        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());

        } finally {
            System.out.println("Finally block executed.");
        }
    }

    // Method that uses 'throw' to manually throw an exception
    static void validateAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Age must be 18 or above. Provided age: " + age);
        }
    }
}
