// Parent class (superclass)
class Shape {
    protected String color;

    Shape(String color) {
        this.color = color;
    }

    void displayColor() {
        System.out.println("Color: " + color);
    }

    void draw() {
        System.out.println("Drawing a generic shape.");
    }
}

// Child class 1
class Circle extends Shape {
    private double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Circle with radius " + radius);
    }
}

// Child class 2
class Rectangle extends Shape {
    private double length, width;

    Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Rectangle " + length + "x" + width);
    }
}

// Child class 3
class Triangle extends Shape {
    private double base, height;

    Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Triangle with base " + base + " and height " + height);
    }
}

// Main class to test hierarchical inheritance
public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        Circle circle = new Circle("Red", 5);
        Rectangle rectangle = new Rectangle("Blue", 4, 6);
        Triangle triangle = new Triangle("Green", 3, 8);

        System.out.println("--- Circle ---");
        circle.draw();
        circle.displayColor();
        System.out.println("Area: " + circle.calculateArea());

        System.out.println("\n--- Rectangle ---");
        rectangle.draw();
        rectangle.displayColor();
        System.out.println("Area: " + rectangle.calculateArea());

        System.out.println("\n--- Triangle ---");
        triangle.draw();
        triangle.displayColor();
        System.out.println("Area: " + triangle.calculateArea());
    }
}
