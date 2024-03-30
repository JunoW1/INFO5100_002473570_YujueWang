import java.io.Serializable;
import java.util.Random;

public class Book implements Serializable {
    private String title;
    private String author;
    private String genre;
    private String ISBN;
    private boolean availability;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ISBN = generateRandomString();
        this.availability = true;
    }

    public static String generateRandomString() {
        String allowedChars = "0123456789";
        int stringLength = 7;
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < stringLength; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            randomString.append(allowedChars.charAt(randomIndex));
        }

        return randomString.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", availability=" + availability +
                '}';
    }
}
