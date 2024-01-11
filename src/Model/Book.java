package Model;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String description;
    private String genre;
    private boolean isAvailable;


    public Book(String title, String author, String description, String genre, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    public Book() {

    }

    public int setBookId(int book_id) {
        return bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public int getBookId() {
        return bookId;
    }
}
