import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final String BOOK_XML_PATH = "src/main/resources/books.xml";
    public static final String BOOK_JSON_PATH = "src/main/resources/books.json";
    public static void main(String[] args) {
        try {
            String xmlData = readFile(BOOK_XML_PATH);
            String jsonData = readFile(BOOK_JSON_PATH);

            BookShelf xmlBookShelf = parseXML(xmlData);
            BookShelf jsonBookShelf = parseJSON(jsonData);

            System.out.println("Books from XML:");
            printBookShelf(xmlBookShelf);
            xmlBookShelf.addBook(new Book("test", 1, 1, Arrays.asList("test")));
            //parse bookShelf to xml and parse back to object
//            System.out.println(xmlBookShelf.toXML());
            BookShelf newXmlBookShelf = parseXML(xmlBookShelf.toXML());

            //check the newly added book
            System.out.println(newXmlBookShelf.getBooks().get(newXmlBookShelf.getBooks().size() - 1).toString());
            System.out.println("==========================================");


            System.out.println("\nBooks from JSON:");
            printBookShelf(jsonBookShelf);
            jsonBookShelf.addBook(new Book("test", 1, 1, Arrays.asList("test")));
            //parse JsonBook Object to json after added new book
            System.out.println(jsonBookShelf.toJSON());
            BookShelf newJsonBookShelf = parseJSON(jsonBookShelf.toJSON());
            //prse Json book back to object and test the newly added book
            System.out.println(newJsonBookShelf.getBooks().get(newJsonBookShelf.getBooks().size() - 1).toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    private static BookShelf parseXML(String xmlData) {

        JSONObject jsonObject = XML.toJSONObject(xmlData);
        JSONArray booksArray = jsonObject.getJSONObject("BookShelf").optJSONArray("Book");
        BookShelf bookShelf = new BookShelf();

        if (booksArray != null) {
            for (Object obj : booksArray) {
                JSONObject bookJson = (JSONObject) obj;
                String title = bookJson.getString("title");
                int publishedYear = bookJson.getInt("publishedYear");
                int numberOfPages = bookJson.getInt("numberOfPages");
                List<String> authors = new ArrayList<>();

                JSONArray authorsArray = bookJson.getJSONObject("authors").optJSONArray("author");
                if (Objects.isNull(authorsArray)) {
                    Object authorsObj = bookJson.get("authors");
                    JSONObject authorJson = (JSONObject) authorsObj;
                    authors.add(authorJson.getString("author"));
                } else {
                    for (Object author : authorsArray) {
                        authors.add(author.toString());
                    }
                }


                Book book = new Book(title, publishedYear, numberOfPages, authors);
                bookShelf.addBook(book);
            }
        }
        return bookShelf;
    }

    private static BookShelf parseJSON(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray booksArray = jsonObject.getJSONObject("BookShelf").getJSONArray("Book");

        BookShelf bookShelf = new BookShelf();
        for (Object obj : booksArray) {
            JSONObject bookJson = (JSONObject) obj;
            String title = bookJson.getString("title");
            int publishedYear = bookJson.getInt("publishedYear");
            int numberOfPages = bookJson.getInt("numberOfPages");
            JSONArray authorsArray = bookJson.getJSONArray("authors");
            List<String> authors = new ArrayList<>();
            for (Object authorObj : authorsArray) {
                authors.add((String) authorObj);
            }
            Book book = new Book(title, publishedYear, numberOfPages, authors);
            bookShelf.addBook(book);
        }
        return bookShelf;
    }

    private static void printBookShelf(BookShelf bookShelf) {
        for (Book book : bookShelf.getBooks()) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Published Year: " + book.getPublishedYear());
            System.out.println("Number of Pages: " + book.getNumberOfPages());
            System.out.println("Authors: " + book.getAuthors());
            System.out.println();
        }
    }
}