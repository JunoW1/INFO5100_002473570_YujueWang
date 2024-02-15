
public class Chair {
    public String name;
    public String color;
    public String material;
    public int legs;
    public boolean isFoldable;
    public boolean isComfortable;
    public boolean isHeightAdjustable;
    public String backrestHeight;

    public Chair(String name) {
        this.name = name;
        System.out.println("Chair instance '" + this.name + "' created.");
    }

    public void sit() {}

    public void adjustHeight() {}

    public void fold() {}
}

