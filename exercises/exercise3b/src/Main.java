import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Shape.setColor("Red");

        Shape square1 = new Square(3);

        try {
            FileOutputStream fileOut = new FileOutputStream("square.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(square1);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in square.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Shape square2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("square.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            square2 = (Square) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized data:");
            System.out.println("Perimeter: " + square2.calculatePerimeter());
            System.out.println("Area: " + square2.calculateArea());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}