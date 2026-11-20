public class LocalInnerClassDemo {

    private String companyName = "TechCorp";

    void processEmployee(String empName, int empSalary) {

        final int bonusPercent = 10;  // effectively final variable, accessible to local class

        // Local inner class - defined inside a method
        class Employee {
            String name;
            int salary;

            Employee(String name, int salary) {
                this.name = name;
                this.salary = salary;
            }

            void displayDetails() {
                double bonus = salary * bonusPercent / 100.0;
                System.out.println("Employee Name: " + name);
                System.out.println("Base Salary: " + salary);
                System.out.println("Bonus (" + bonusPercent + "%): " + bonus);
                System.out.println("Total Salary: " + (salary + bonus));
                // Local class can access outer class's instance members too
                System.out.println("Company: " + companyName);
            }
        }

        // Object of local inner class created and used within the same method
        Employee emp = new Employee(empName, empSalary);
        emp.displayDetails();
    }

    public static void main(String[] args) {
        System.out.println("----- Processing Employee 1 -----");
        LocalInnerClassDemo demo = new LocalInnerClassDemo();
        demo.processEmployee("Ravi Sharma", 50000);

        System.out.println("\n----- Processing Employee 2 -----");
        demo.processEmployee("Anita Patel", 60000);
    }
}
