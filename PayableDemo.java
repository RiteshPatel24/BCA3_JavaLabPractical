// Interface definition
interface Payable {
    void pay(double amount);
    
    // default method
    default void printReceipt() {
        System.out.println("Receipt generated. Thank you!");
    }
}

// Class implementing the interface
class Customer implements Payable {
    private String name;

    Customer(String name) {
        this.name = name;
    }

    @Override
    public void pay(double amount) {
        System.out.println(name + " paid $" + amount + " via Credit Card.");
    }
}

// Another class implementing the same interface differently
class Vendor implements Payable {
    private String businessName;

    Vendor(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public void pay(double amount) {
        System.out.println(businessName + " received payment of $" + amount + " via Bank Transfer.");
    }
}

// Main class to test the interface
public class PayableDemo {
    public static void main(String[] args) {
        Payable customer = new Customer("Ravi Patel");
        Payable vendor = new Vendor("TechSupplies Inc.");

        customer.pay(150.50);
        customer.printReceipt();

        System.out.println();

        vendor.pay(2400.00);
        vendor.printReceipt();
    }
}
