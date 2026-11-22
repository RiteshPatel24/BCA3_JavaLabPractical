// Abstract class
abstract class Employee {
    protected String name;
    protected int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Abstract method (no body) - must be implemented by subclasses
    abstract double calculateSalary();

    // Concrete method (has a body) - shared by all subclasses
    void displayBasicInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
    }
}

// Concrete subclass 1
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

// Concrete subclass 2
class Freelancer extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    Freelancer(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Main class to test the abstract class
public class AbstractClassDemo {
    public static void main(String[] args) {
        // Employee emp = new Employee("Test", 1); // NOT allowed - can't instantiate abstract class

        Employee emp1 = new FullTimeEmployee("Alice Johnson", 101, 5000.0);
        Employee emp2 = new Freelancer("Bob Smith", 102, 25.0, 160);

        System.out.println("--- Full-Time Employee ---");
        emp1.displayBasicInfo();
        System.out.println("Salary: $" + emp1.calculateSalary());

        System.out.println("\n--- Freelancer ---");
        emp2.displayBasicInfo();
        System.out.println("Salary: $" + emp2.calculateSalary());
    }
}

