public class Laptop {
    public String name;
    public String brand;
    public String processor;
    public String ramSize;
    public String storageCapacity;
    public double screenSize;
    public boolean isTouchscreen;
    public String batteryLife;

    public Laptop(String name) {
        this.name = name;
        System.out.println("Laptop instance '" + this.name + "' created.");
    }

    public void powerOn() {}

    public void openProgram() {}

    public void sleepMode() {}
}
