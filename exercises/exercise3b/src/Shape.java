public abstract class Shape {
    public static String color;
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public static void setColor(String c) {
        color = c;
    }
}