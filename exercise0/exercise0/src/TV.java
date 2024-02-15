public class TV {
    public String brand;
    public String model;
    public int screenSize;
    public String displayType;
    public boolean hasRemoteControl;
    public boolean isSmart;
    public int year;
    public String color;

    public TV() {
        System.out.println("Television instance created.");
    }

    public void turnOn() {
        System.out.println("Turning on the television.");
    }

    public void changeChannel() {
        System.out.println("Changing the channel on the television.");
    }

    public void adjustVolume() {
        System.out.println("Adjusting the volume on the television.");
    }
}
