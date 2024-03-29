public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Honda", "Civic", 2021);
        Car car3 = new Car("Ford", "Mustang", 2020);

        Car.Engine engine1_1 = car1.new Engine();
        Car.Engine engine2_1 = car2.new Engine();
        Car.Engine engine3_3 = car3.new Engine();

        Laptop dellLaptop = new Laptop("Dell");
        Laptop hpLaptop = new Laptop("HP");
        Laptop macbook = new Laptop("Apple");

        Chair highChair = new Chair("high");
        Chair lowChair = new Chair("low");
        Chair normalChair = new Chair("normal");

        Desk standDesk = new Desk("stand");
        Desk tableDesk = new Desk("table");
        Desk classDesk = new Desk("class");

        TV samsungTV = new TV();
        TV lgTV = new TV();
        TV sonyTV = new TV();

        Smartphone iphone12 = new Smartphone("Apple");
        Smartphone samsungS21 = new Smartphone("Samsung");
        Smartphone googlePixel5 = new Smartphone("Google");

        Bookshelf woodenShelf = new Bookshelf("WoodenShelf");
        Bookshelf metalShelf = new Bookshelf("MetalShelf");
        Bookshelf glassShelf = new Bookshelf("GlassShelf");

        Bookshelf.Book harryPotter = woodenShelf.new Book("Harry Potter", "J.K. Rowling");
        Bookshelf.Book toKillAMockingbird = metalShelf.new Book("To Kill a Mockingbird", "Harper Lee");
        Bookshelf.Book prideAndPrejudice = glassShelf.new Book("Pride and Prejudice", "Jane Austen");

        House smallHouse = new House(1,1);
        House mediumHouse = new House(5,4);
        House largeHouse = new House(10,10);
    }
}