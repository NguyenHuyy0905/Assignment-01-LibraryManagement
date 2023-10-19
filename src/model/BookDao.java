package model;

import entity.Book;

import java.util.List;

public interface BookDao {
    public void createBook(Book book);
    public void deleteBookById(int id);
    public List<Book> getAllBooks();
    public Book findBookById(int id);
    public Book findBookByTitle(String title); // Coi đầu sách là duy nhất
    public List<Book> findBookByAuthor(String author); // Một tác giả có nhiều đầu sách
    public List<Book> findBookByPublisher(String publisher); // Một NXB có nhiều đầu sách
    public List<Book> findBookByCategory(String category); // Một danh mục có nhiều đầu sách
    public List<Book> findBookWithPriceIn(double lessPrice, double greaterPrice); // Tìm kiếm sách trong khoảng giá
}
