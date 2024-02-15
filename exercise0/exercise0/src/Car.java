public class Car {
    public String make;
    public String model;
    public int year;
    public String color;
    public double engineSize;
    public int mileage;
    public boolean isAutomatic;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        System.out.println("Car instance '" + this.year + " " + this.make + " " + this.model + "' created.");
    }

    public void run(){}
    public void horn(){}
    public void playMusic(){}

    public class Engine {
        public String type;
        public int horsepower;
        public int cylinders;
        public double displacement;
        public boolean turbocharged;
        public String year;
        public String color;
        public boolean isAutomatic;

        public Engine() {
            System.out.println("Car engine instance created.");
        }

        public void start() {
        }

        public void stop() {
        }

        public void accelerate() {
        }
    }
}
