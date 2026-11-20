// Parent class
class Animal {
    protected String name;

    Animal(String name) {
        this.name = name;
    }

    // Method to be overridden
    void makeSound() {
        System.out.println(name + " makes a generic animal sound.");
    }

    void eat() {
        System.out.println(name + " eats food.");
    }
}

// Child class 1 - overrides makeSound()
class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
}

// Child class 2 - overrides makeSound()
class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
}

// Child class 3 - overrides makeSound() AND eat()
class Snake extends Animal {
    Snake(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " hisses: Ssssss!");
    }

    @Override
    void eat() {
        System.out.println(name + " swallows its prey whole.");
    }
}

// Main class to test method overriding
public class MethodOverridingDemo {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal("Some Creature");
        Animal dog = new Dog("Rex");
        Animal cat = new Cat("Whiskers");
        Animal snake = new Snake("Kaa");

        genericAnimal.makeSound();
        genericAnimal.eat();

        System.out.println();
        dog.makeSound();  // overridden version runs
        dog.eat();         // inherited version runs (not overridden)

        System.out.println();
        cat.makeSound();
        cat.eat();

        System.out.println();
        snake.makeSound();
        snake.eat();      // overridden version runs
    }
}
