abstract class Shape {
    abstract double area();

    void printArea() {
        System.out.println("Area is : " + area());
    }
}

class Circle extends Shape {
    double radius;

    Circle(double r) {
        this.radius = r;
    }

    @Override
    double area() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shape {
    double length;
    double breadth;

    Rectangle(double l, double b) {
        this.length = l;
        this.breadth = b;
    }

    @Override
    double area() {
        return length * breadth;
    }
}

class Triangle extends Shape {
    double breadth;
    double height;

    Triangle(double b, double h) {
        this.breadth = b;
        this.height = h;
    }

    @Override
    double area() {
        return 0.5 * breadth * height;
    }
}

public class AreaCalcOOPS {
    public static void main(String[] args) {
        Shape[] s = new Shape[3];
        s[0] = new Circle(5);
        s[1] = new Rectangle(6, 8);
        s[2] = new Triangle(10, 20);
        for (Shape s1 : s) {
            s1.printArea();
        }
    }
}