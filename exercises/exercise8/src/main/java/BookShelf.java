import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {

    private List<Book> books;

    public BookShelf() {
        this.books = new ArrayList<>();
    }


    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public String toJSON() {
        JSONArray jsonBooks = new JSONArray();
        for (Book book : books) {
            jsonBooks.put(book.toJSON());
        }
        JSONObject jsonBookShelf = new JSONObject();
        jsonBookShelf.put("BookShelf", new JSONObject().put("Book", jsonBooks));
        return jsonBookShelf.toString().replaceAll("\\\\\"", "\"");
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlBuilder.append("<BookShelf>\n");
        for (Book book : books) {
            xmlBuilder.append(book.toXML()).append("\n");
        }
        xmlBuilder.append("</BookShelf>");
        return xmlBuilder.toString();
    }
}
