package Model;

import javax.swing.*;

public class Book {
    private int book_template_id;

    public int getBook_template_id() {
        return book_template_id;
    }

    public void setBook_template_id(int book_template_id) {
        this.book_template_id = book_template_id;
    }

    private int bookId;
    private String title;
    private String author;
    private String description;
    private String genre;
    private boolean isFavourite;
    private boolean isRented;
    private boolean isReserved;
    private ImageIcon imageIcon;
    private String imagePath;
    private String startDate;
    private String finishDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public Book(int bookId, String title, String author, String description, String genre, boolean isFavourite, boolean isRented, boolean isReserved, ImageIcon imageIcon, String imagePath) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.isFavourite = isFavourite;
        this.isRented = isRented;
        this.isReserved = isReserved;
        this.imageIcon = imageIcon;
        this.imagePath = imagePath;
    }

    public Book() {

    }

    public Book(String title, String author, String genre, String description, String image) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.imagePath = image;
    }

    public int setBookId(int book_id) {
        return bookId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public ImageIcon getImageCon() {
        return imageIcon;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    //TO DO: methods to get dates
    public String getRentedDate() {
        return "";
    }

    public String getDeadlineDate() {
        return "";
    }

    public void setBookID(int i) {
        this.bookId = i;
    }

    public void setBookName(String the_lord_of_the_rings) {
        this.title = the_lord_of_the_rings;
    }
}
