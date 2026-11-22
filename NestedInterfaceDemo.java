public class NestedInterfaceDemo {

    // Nested interface - defined inside the outer class
    interface Greetable {
        void greet(String name);
    }

    // Another class implementing the nested interface
    static class EnglishGreeting implements Greetable {
        public void greet(String name) {
            System.out.println("Hello, " + name + "! Welcome.");
        }
    }

    static class HindiGreeting implements Greetable {
        public void greet(String name) {
            System.out.println("Namaste, " + name + "! Swagat hai.");
        }
    }

    public static void main(String[] args) {

        System.out.println("----- Using EnglishGreeting -----");
        NestedInterfaceDemo.Greetable englishGreeter = new EnglishGreeting();
        englishGreeter.greet("Ravi");

        System.out.println("\n----- Using HindiGreeting -----");
        NestedInterfaceDemo.Greetable hindiGreeter = new HindiGreeting();
        hindiGreeter.greet("Anita");

        System.out.println("\n----- Using Anonymous Class for Nested Interface -----");
        Greetable anonymousGreeter = new Greetable() {
            public void greet(String name) {
                System.out.println("Hey " + name + ", greetings from an anonymous class!");
            }
        };
        anonymousGreeter.greet("Sam");
    }
}
