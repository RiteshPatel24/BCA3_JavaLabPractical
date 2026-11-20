// Level 1: Grandparent class
class Person {
    protected String name;
    protected int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Level 2: Parent class extending Person
class Employee extends Person {
    protected String employeeId;
    protected double salary;

    Employee(String name, int age, String employeeId, double salary) {
        super(name, age); // calls Person constructor
        this.employeeId = employeeId;
        this.salary = salary;
    }

    void displayEmployeeInfo() {
        displayPersonInfo(); // inherited from Person
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: $" + salary);
    }
}

// Level 3: Child class extending Employee
class Manager extends Employee {
    private String department;
    private int teamSize;

    Manager(String name, int age, String employeeId, double salary, String department, int teamSize) {
        super(name, age, employeeId, salary); // calls Employee constructor
        this.department = department;
        this.teamSize = teamSize;
    }

    void displayManagerInfo() {
        displayEmployeeInfo(); // inherited chain: Employee -> Person
        System.out.println("Department: " + department);
        System.out.println("Team Size: " + teamSize);
    }
}

// Main class to test multilevel inheritance
public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        Manager manager = new Manager("Alice Johnson", 35, "EMP1023", 85000, "Engineering", 12);

        System.out.println("--- Manager Details ---");
        manager.displayManagerInfo();

        System.out.println();

        // Demonstrating access to methods at every inheritance level
        System.out.println("--- Direct method calls at each level ---");
        manager.displayPersonInfo();   // from Person (Level 1)
        manager.displayEmployeeInfo(); // from Employee (Level 2)
    }
}
