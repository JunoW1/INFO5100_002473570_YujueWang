public class Desk {
    public String name;
    public String material;
    public String color;
    public int width;
    public int height;
    public int depth;
    public boolean hasDrawers;
    public boolean isAdjustable;

    public Desk(String name) {
        this.name = name;
        System.out.println("Desk instance '" + this.name + "' created.");
    }

    public void work() {}

    public void openDrawer() {}

    public void adjustHeight() {}
}

