// Parent class (superclass)
class Vehicle {
    protected String brand;
    protected int speed;

    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
    }

    void honk() {
        System.out.println(brand + " says: Beep beep!");
    }
}

// Child class (subclass) inheriting from Vehicle
class Car extends Vehicle {
    private int numDoors;

    Car(String brand, int speed, int numDoors) {
        super(brand, speed); // calling parent constructor
        this.numDoors = numDoors;
    }

    // Additional method specific to Car
    void displayCarInfo() {
        displayInfo(); // inherited method
        System.out.println("Number of doors: " + numDoors);
    }

    // Overriding parent method
    @Override
    void honk() {
        System.out.println(brand + " says: Honk honk! (car horn)");
    }
}

// Main class to test inheritance
public class InheritanceDemo {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 180, 4);

        myCar.displayCarInfo(); // uses inherited + own method
        myCar.honk();           // uses overridden method

        System.out.println();

        // Parent class object for comparison
        Vehicle myVehicle = new Vehicle("Generic Bike", 60);
        myVehicle.displayInfo();
        myVehicle.honk();
    }
}
