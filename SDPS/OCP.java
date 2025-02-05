
public class OCP {
    // Step 1: Define an interface
interface Shape {
    double calculateArea();
}

// Step 2: Implement concrete classes
class Circle implements Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Step 3: Create a Calculator class that works with any shape
class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea(); // Polymorphism in action
    }
}

//without OCP
// class AreaCalculator {
//     public double calculateArea(Object shape) {
//         if (shape instanceof Circle) {
//             Circle c = (Circle) shape;
//             return Math.PI * c.radius * c.radius;
//         } else if (shape instanceof Rectangle) {
//             Rectangle r = (Rectangle) shape;
//             return r.length * r.width;
//         }
//         return 0;
//     }
// }


// Step 4: Usage
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Circle Area: " + calculator.calculateArea(circle));
        System.out.println("Rectangle Area: " + calculator.calculateArea(rectangle));
    }
}

}
