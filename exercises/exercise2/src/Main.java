//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Shape.setColor("Red");

        // Create instances of different shapes
        Shape triangle = new Triangle(3, 4);
        Shape rectangle = new Rectangle(4, 5);
        Shape circle = new Circle(2);
        Shape square = new Square(3);

        // Demonstrate polymorphism
        Shape[] shapes = {triangle, rectangle, circle, square};

        // Calculate and print area and perimeter of each shape
        for (Shape shape : shapes) {
            System.out.println("Area of " + shape.getClass().getSimpleName() + ": " + shape.calculateArea());
            System.out.println("Perimeter of " + shape.getClass().getSimpleName() + ": " + shape.calculatePerimeter());
            System.out.println("Color of " + shape.getClass().getSimpleName() + ": " + Shape.color);
            System.out.println();
        }
    }
}