// First interface
interface Machine {
    void start();
    
    default void status() {
        System.out.println("Machine is operational.");
    }
}

// Second interface
interface RemoteControllable {
    void connect();
    
    default void status() {
        System.out.println("Remote connection is active.");
    }
}

// Third interface
interface Chargeable {
    void charge();
}

// Class implementing multiple interfaces
// Note: Machine and RemoteControllable both have status() -> must override to resolve conflict
class RobotVacuum implements Machine, RemoteControllable, Chargeable {
    private String model;

    RobotVacuum(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " has started cleaning.");
    }

    @Override
    public void connect() {
        System.out.println(model + " connected to the mobile app.");
    }

    @Override
    public void charge() {
        System.out.println(model + " is charging on the dock.");
    }

    // Resolving the diamond problem: explicitly override the conflicting default method
    @Override
    public void status() {
        // Optionally call a specific interface's version using InterfaceName.super.method()
        Machine.super.status();
        RemoteControllable.super.status();
        System.out.println(model + " is fully online.");
    }
}

// Main class to test
public class MultipleInheritanceInterfaceDemo {
    public static void main(String[] args) {
        RobotVacuum robot = new RobotVacuum("iClean 3000");

        robot.start();
        robot.connect();
        robot.charge();
        robot.status();
    }
}
