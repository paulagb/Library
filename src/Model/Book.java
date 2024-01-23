package Model;

import javax.swing.*;

public class Book {
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
    public ImageIcon getImageCon(){return imageIcon;}

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    //TO DO: methods to get dates
    public String getRentedDate(){return "";}

    public String getDeadlineDate(){return "";}

}
