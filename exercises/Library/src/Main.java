import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        generateBooks(library);

        //Testing search function
        System.out.println("==================================");
        System.out.println("Test search by title function:");
        Book res = library.searchBookByTitle("The Hobbit");
        System.out.println(res.toString());

        System.out.println("Test search by author function:");
        List<Book> list = library.searchBookByAuthor("J.R.R. Tolkien");
        System.out.println(list);

        System.out.println("Test search by genre function:");
        list = library.searchBookByGenre("Classic");
        System.out.println(list);

        //Removing book from library
        //Book exists
        System.out.println("==================================");
        System.out.println("Test removing function:");
        boolean isSuccess = library.removeBookByTitle("1984");
        System.out.println("Test remove exists result:" + isSuccess);

        //Book not exists
        isSuccess = library.removeBookByTitle("1964");
        System.out.println("Test remove non exists result:" + isSuccess);

        //Displaying all available books
        System.out.println("==================================");
        System.out.println("Displaying all available books");
        library.displayAllAvailableBooks();

        //Testing check-out  & return book
        System.out.println("==================================");
        System.out.println("Checking out & return a book.");

        boolean isCheckOut = library.checkOutBookByTitle("Fahrenheit 451");
        System.out.println("Success checkout: " + isCheckOut);

        isCheckOut = library.checkOutBookByTitle("1984");
        System.out.println("Try checkout non exist book: " + isCheckOut);

        boolean isReturned = library.removeBookByTitle("Fahrenheit 451");
        System.out.println("Success returned: " + isReturned);

        //Implement serialization/deserialization to save and load the library data from a file
        try {
            FileOutputStream fileOut = new FileOutputStream("library.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(library);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in library.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Library library2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("library.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            library2 = (Library) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized data:");
            System.out.println("Library books count:" + library2.getBooks().size());
            System.out.println("Display all available book after deserialize.");
            library2.displayAllAvailableBooks();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void generateBooks(Library library) {
        List<String> bookNames = Arrays.asList(
                "To Kill a Mockingbird",
                "1984",
                "The Great Gatsby",
                "Pride and Prejudice",
                "The Catcher in the Rye",
                "Animal Farm",
                "Brave New World",
                "The Lord of the Rings",
                "The Hobbit",
                "Fahrenheit 451"
        );

        List<String> authorNames = Arrays.asList(
                "Harper Lee",
                "George Orwell",
                "F. Scott Fitzgerald",
                "Jane Austen",
                "J.D. Salinger",
                "George Orwell",
                "Aldous Huxley",
                "J.R.R. Tolkien",
                "J.R.R. Tolkien",
                "Ray Bradbury"
        );

        List<String> genres = Arrays.asList(
                "Fiction",
                "Science Fiction",
                "Classic",
                "Romance",
                "Coming-of-Age",
                "Satire",
                "Dystopian",
                "Fantasy",
                "Fantasy",
                "Dystopian"
        );

        for(int i = 0; i < 10; i++) {
            //Adding new Book to the library
            Book b = new Book(bookNames.get(i), authorNames.get(i), genres.get(i));
            library.addBook(b);
        }
    }


}