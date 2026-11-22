public class StaticInnerClassDemo {

    private static String companyName = "TechCorp";
    private int outerInstanceVar = 100;

    // Static inner class - belongs to the outer class itself, not any instance
    static class Department {
        String deptName;
        int deptId;

        Department(String deptName, int deptId) {
            this.deptName = deptName;
            this.deptId = deptId;
        }

        void displayDetails() {
            // Static inner class can directly access static members of outer class
            System.out.println("Department ID: " + deptId);
            System.out.println("Department Name: " + deptName);
            System.out.println("Company Name: " + companyName);
            // Note: outerInstanceVar (non-static) CANNOT be accessed here directly
        }
    }

    public static void main(String[] args) {
        System.out.println("----- Creating Static Inner Class Objects -----");
        // No need to create an outer class object first
        StaticInnerClassDemo.Department dept1 = new StaticInnerClassDemo.Department("Engineering", 1);
        StaticInnerClassDemo.Department dept2 = new StaticInnerClassDemo.Department("Marketing", 2);

        System.out.println("\n----- Department 1 Details -----");
        dept1.displayDetails();

        System.out.println("\n----- Department 2 Details -----");
        dept2.displayDetails();
    }
}
