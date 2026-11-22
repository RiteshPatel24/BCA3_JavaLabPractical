public class InnerClassDemo {

    private String companyName = "TechCorp";

    // Inner class - defined inside the outer class
    class Employee {
        String empName;
        int empId;

        Employee(String empName, int empId) {
            this.empName = empName;
            this.empId = empId;
        }

        void displayDetails() {
            // Inner class can directly access outer class's private members
            System.out.println("Employee ID: " + empId);
            System.out.println("Employee Name: " + empName);
            System.out.println("Company Name: " + companyName);
        }
    }

    public static void main(String[] args) {
        System.out.println("----- Creating Outer Class Object -----");
        InnerClassDemo outerObj = new InnerClassDemo();

        System.out.println("\n----- Creating Inner Class Object -----");
        // Inner class object must be created using outer class object
        InnerClassDemo.Employee emp1 = outerObj.new Employee("Ravi Sharma", 101);
        InnerClassDemo.Employee emp2 = outerObj.new Employee("Anita Patel", 102);

        System.out.println("\n----- Employee 1 Details -----");
        emp1.displayDetails();

        System.out.println("\n----- Employee 2 Details -----");
        emp2.displayDetails();
    }
}
