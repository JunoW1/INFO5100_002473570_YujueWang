public class House {
    public String type;
    public int bedrooms;
    public int bathrooms;
    public boolean hasBackyard;
    public double area;
    public String location;
    public int floors;
    public boolean isFurnished;

    public House(int bedrooms, int bathrooms) {
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        System.out.println("House instance has " + bedrooms + " bedrooms and " + bathrooms + "bathrooms.");
    }

    public void openDoor() {}

    public void turnOnLights() {}

    public void mowLawn() {}
}
