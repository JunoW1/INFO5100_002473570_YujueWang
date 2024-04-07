import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Book {

    private String title;
    private int publishedYear;
    private int numberOfPages;
    private List<String> authors;

    public Book(String title, int publishedYear, int numberOfPages, List<String> authors) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public JSONObject toJSON() {
        JSONObject jsonBook = new JSONObject();
        jsonBook.put("title", title);
        jsonBook.put("publishedYear", publishedYear);
        jsonBook.put("numberOfPages", numberOfPages);
        JSONArray authorsArray = new JSONArray(authors);
        jsonBook.put("authors", authorsArray);
        return jsonBook;
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Book>\n");
        xmlBuilder.append("    <title>").append(title).append("</title>\n");
        xmlBuilder.append("    <publishedYear>").append(publishedYear).append("</publishedYear>\n");
        xmlBuilder.append("    <numberOfPages>").append(numberOfPages).append("</numberOfPages>\n");
        xmlBuilder.append("    <authors>\n");
        for (String author : authors) {
            xmlBuilder.append("        <author>").append(author).append("</author>\n");
        }
        xmlBuilder.append("    </authors>\n");
        xmlBuilder.append("</Book>");
        return xmlBuilder.toString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", publishedYear=" + publishedYear +
                ", numberOfPages=" + numberOfPages +
                ", authors=" + authors +
                '}';
    }
}
