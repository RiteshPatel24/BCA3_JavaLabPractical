// Base interface
interface Animal {
    void eat();
    
    default void breathe() {
        System.out.println("Breathing...");
    }
}

// Sub-interface extending Animal
interface Pet extends Animal {
    void play();
    
    default void showAffection() {
        System.out.println("Wagging tail happily!");
    }
}

// Another interface can extend multiple interfaces too (just noting this is possible)
// interface Example extends Animal, SomeOtherInterface { }

// Class implementing the extended interface
class Dog implements Pet {
    private String name;

    Dog(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating food.");
    }

    @Override
    public void play() {
        System.out.println(name + " is playing fetch.");
    }
}

class Cat implements Pet {
    private String name;

    Cat(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating fish.");
    }

    @Override
    public void play() {
        System.out.println(name + " is playing with yarn.");
    }

    // Overriding the default method
    @Override
    public void showAffection() {
        System.out.println(name + " is purring.");
    }
}

// Main class to test
public class InterfaceExtendsDemo {
    public static void main(String[] args) {
        Pet dog = new Dog("Buddy");
        Pet cat = new Cat("Whiskers");

        System.out.println("--- Dog ---");
        dog.eat();          // from Animal
        dog.breathe();      // from Animal (default)
        dog.play();         // from Pet
        dog.showAffection(); // from Pet (default)

        System.out.println("\n--- Cat ---");
        cat.eat();          // from Animal
        cat.breathe();      // from Animal (default)
        cat.play();         // from Pet
        cat.showAffection(); // overridden default
    }
}
