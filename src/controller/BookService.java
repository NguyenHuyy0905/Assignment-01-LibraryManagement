package controller;

import entity.Book;
import model.BookDao;
import model.BookDaoImpl;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDaoImpl();
    public void createBook(Book book) {
        bookDao.createBook(book);
    }
    public void deleteBookById(int id) {
        bookDao.deleteBookById(id);
    }
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
    public Book findBookById(int id) {
        return bookDao.findBookById(id);
    }
    public Book findBookByTitle(String title) {
        return bookDao.findBookByTitle(title);
    }
    public List<Book> findBookByAuthor(String author) {
        return bookDao.findBookByAuthor(author);
    }
    public List<Book> findBookByPublisher(String publisher) {
        return bookDao.findBookByPublisher(publisher);
    }
    public List<Book> findBookByCategory(String category) {
        return bookDao.findBookByCategory(category);
    }
    public List<Book> findBookWithPriceIn(double lessPrice, double greaterPrice) {
        return bookDao.findBookWithPriceIn(lessPrice, greaterPrice);
    }
}
