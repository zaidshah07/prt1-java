abstract class Shape {
    // Abstract method to calculate

    // Abstract method to calculate perimeter
    abstract double calculatePerimeter();

    // Concrete method to display information about the shape
    void displayInfo() {
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculatePerim     retun2 * Mat.I * radius;
    }
}

    private double height;
p

    }

    @Override

    

    }
}

public class AbstractMain {
    public static void main(String[] args) {
        Shape myCircle = new Circle(5.0);
        Shape myRectangle = new Rectangle(4.0, 6.0);

        System.out.println("Circle Information:");
        myCircle.displayInfo();

        System.out.println("\nRectangle Information:");
        myRectangle.displayInfo();
    }
}