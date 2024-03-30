import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements Serializable {

    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                return b;
            }
        }
        return null;
    }
    public List<Book> searchBookByGenre(String genre) {
        List<Book> res = new ArrayList<>();
        for (Book b : books) {
            if (b.getGenre().equals(genre)) {
                res.add(b);
            }
        }
        return res;
    }

    public List<Book> searchBookByAuthor(String author) {
        List<Book> res = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equals(author)) {
                res.add(b);
            }
        }
        return res;
    }

    public boolean removeBookByTitle(String title) {
        int index = -1;
        for(int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if(b.getTitle().equals(title)) {
                index = i;
            }
        }
        try {
            books.remove(index);
        } catch(Exception e) {
            System.out.println("Book not exist");
            return false;
        }

        return true;
    }

    public void displayAllAvailableBooks() {
        for (Book b : books) {
            if (b.isAvailability()) {
                System.out.println(b.toString());
            }
        }
    }

    public boolean checkOutBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title) && b.isAvailability()) {
                b.setAvailability(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title) && !b.isAvailability()) {
                b.setAvailability(true);
                return true;
            }
        }
        return false;
    }
}
