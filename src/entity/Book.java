package entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Book {
    private int book_id;
    private String title;
    private String author;
    private String publisher;
    private String category;
    private double price;
    private Date import_date;
    private boolean isAvailable;
    public Book() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        this.isAvailable = true;
        this.import_date = new Date(currentTimestamp.getTime());
    }

    public Book(String title, String author, String publisher, String category, double price) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
        this.import_date = new Date(currentTimestamp.getTime());

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

    public java.sql.Date getImport_date() {
        return import_date;
    }

    public void setImport_date(Date import_date) {
        this.import_date = import_date;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Sách {" +
                "id: " + book_id +
                ", Tên sách:'" + title + '\'' +
                ", Tác giả: '" + author + '\'' +
                ", NXB: '" + publisher + '\'' +
                ", Thể loại: '" + category + '\'' +
                ", Giá: " + price +
                ", Ngày nhập: " + import_date +
                ", Trạng thái: " + (isAvailable == true ? "Còn trong thư viện" : "Có người mượn") +
                "}\n";
    }
}
