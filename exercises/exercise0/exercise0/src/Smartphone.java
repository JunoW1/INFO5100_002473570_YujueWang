public class Smartphone {
    public String name;
    public String brand;
    public String operatingSystem;
    public int storageCapacity;
    public double screenSize;
    public boolean isWaterResistant;
    public boolean hasFaceRecognition;
    public String color;

    public Smartphone(String name) {
        this.name = name;
        System.out.println("Smartphone instance '" + this.name + "' created.");
    }

    public void makeCall() {}

    public void takePhoto() {}

    public void unlock() {}
}
