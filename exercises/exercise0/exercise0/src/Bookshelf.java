public class Bookshelf {
    public String name;
    public String materia;
    public String color;
    public int numShelves;
    public boolean isModular;
    public boolean hasDrawer;
    public int height;
    public int width;

    public Bookshelf(String name) {
        this.name = name;
        System.out.println("Bookshelf instance '" + this.name + "' created.");
    }

    public void organizeBooks() {}

    public void addBook() {}

    public void openDrawer() {}

    public class Book {
        public String title;
        public String author;
        public String genre;
        public int pages;
        public boolean isHardcover;
        public String color;
        public String year;
        public String language;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            System.out.println("Book instance '" + this.title + "' created.");
        }

        public void read() {}

        public void bookmark() {}

        public void close() {}
    }
}
