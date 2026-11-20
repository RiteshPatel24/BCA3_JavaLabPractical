// Abstract class
abstract class Appliance {
    protected String brand;

    Appliance(String brand) {
        this.brand = brand;
    }

    // Abstract method - no body, must be overridden by subclasses
    abstract void operate();

    // Abstract method - another one to override
    abstract double powerConsumption();

    // Concrete method - shared, can also be overridden if needed
    void displayBrand() {
        System.out.println("Brand: " + brand);
    }
}

// Concrete subclass 1 - overrides both abstract methods
class WashingMachine extends Appliance {
    WashingMachine(String brand) {
        super(brand);
    }

    @Override
    void operate() {
        System.out.println(brand + " washing machine is washing clothes.");
    }

    @Override
    double powerConsumption() {
        return 500.0; // watts
    }
}

// Concrete subclass 2 - overrides both abstract methods differently
class Refrigerator extends Appliance {
    Refrigerator(String brand) {
        super(brand);
    }

    @Override
    void operate() {
        System.out.println(brand + " refrigerator is cooling food.");
    }

    @Override
    double powerConsumption() {
        return 150.0; // watts
    }

    // Also overriding the concrete method from the abstract class
    @Override
    void displayBrand() {
        System.out.println("Refrigerator Brand: " + brand);
    }
}

// Main class to test overriding of abstract class methods
public class AbstractOverridingDemo {
    public static void main(String[] args) {
        Appliance washer = new WashingMachine("LG");
        Appliance fridge = new Refrigerator("Samsung");

        System.out.println("--- Washing Machine ---");
        washer.displayBrand();
        washer.operate();
        System.out.println("Power Consumption: " + washer.powerConsumption() + "W");

        System.out.println("\n--- Refrigerator ---");
        fridge.displayBrand();
        fridge.operate();
        System.out.println("Power Consumption: " + fridge.powerConsumption() + "W");
    }
}

