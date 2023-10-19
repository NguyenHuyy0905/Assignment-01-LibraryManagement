package entity;

import java.util.Date;

public class Book {
    private int book_id;
    private String title;
    private String author;
    private String publisher;
    private String category;
    private double price;
    private Date import_date;
    private Status status;
    public Book() {}

    public Book(String title, String author, String publisher, String category, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.price = price;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getImport_date() {
        return import_date;
    }

    public void setImport_date(Date import_date) {
        this.import_date = import_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
