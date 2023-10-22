package model;

import dao.DBConnection;
import entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDaoImpl implements BookDao{
    private final Connection conn = DBConnection.createConnection();
    private final String SQL_CREATE_BOOK = "INSERT INTO books (title, author, publisher, category, price, import_date, isAvailable) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private final String SQL_DELETE_BOOK_BY_ID = "DELETE FROM books WHERE book_id = ?;";
    private final String SQL_GET_ALL_BOOKS = "SELECT * FROM books;";
    private final String SQL_FIND_BOOK_BY_ID = "SELECT * FROM books WHERE book_id = ?;";
    private final String SQL_FIND_BOOK_BY_TITLE = "SELECT * FROM books WHERE title = ?;";
    private final String SQL_FIND_BOOK_BY_AUTHOR = "SELECT * FROM books WHERE author = ?;";
    private final String SQL_FIND_BOOK_BY_CATEGORY = "SELECT * FROM books WHERE category = ?;";
    private final String SQL_FIND_BOOK_BY_PUBLISHER = "SELECT * FROM books WHERE publisher = ?;";
    private final String SQL_FIND_BOOK_WITH_PRICE_IN = "SELECT * FROM books WHERE price BETWEEN ? AND ?;";
    @Override
    public void createBook(Book book) {
        try (PreparedStatement pstm = conn.prepareStatement(SQL_CREATE_BOOK, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, book.getTitle());
            pstm.setString(2, book.getAuthor());
            pstm.setString(3, book.getPublisher());
            pstm.setString(4, book.getCategory());
            pstm.setDouble(5, book.getPrice());
            pstm.setDate(6, book.getImport_date());
            pstm.setBoolean(7, book.isAvailable());
            pstm.executeUpdate();
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    book.setBook_id(rs.getInt(1));
                }
            }
            System.out.println("Thêm sách mới thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteBookById(int id) {
        try (PreparedStatement pstm = conn.prepareStatement(SQL_DELETE_BOOK_BY_ID)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
            System.out.println("Xóa đầu sách thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(SQL_GET_ALL_BOOKS);
            ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                Book book = new Book();
                book.setBook_id(rs.getInt(1));
                book.setTitle(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPublisher(rs.getString(4));
                book.setCategory(rs.getString(5));
                book.setPrice(rs.getDouble(6));
                book.setImport_date(rs.getDate(7));
                book.setAvailable(rs.getBoolean(8));
                bookList.add(book);
            }
            System.out.println(bookList);
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookList;
    }

    @Override
    public Book findBookById(int id) {
        Book book = new Book();
        try (PreparedStatement pstm = conn.prepareStatement(SQL_FIND_BOOK_BY_ID)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    book.setBook_id(rs.getInt(1));
                    book.setTitle(rs.getString(2));
                    book.setAuthor(rs.getString(3));
                    book.setPublisher(rs.getString(4));
                    book.setCategory(rs.getString(5));
                    book.setPrice(rs.getDouble(6));
                    book.setImport_date(rs.getDate(7));
                    book.setAvailable(rs.getBoolean(8));
                }
            }
            System.out.println(book);
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }

    @Override
    public Book findBookByTitle(String title) {
        Book book = new Book();
        try (PreparedStatement pstm = conn.prepareStatement(SQL_FIND_BOOK_BY_TITLE)) {
            pstm.setString(1, title);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    book.setBook_id(rs.getInt(1));
                    book.setTitle(rs.getString(2));
                    book.setAuthor(rs.getString(3));
                    book.setPublisher(rs.getString(4));
                    book.setCategory(rs.getString(5));
                    book.setPrice(rs.getDouble(6));
                    book.setImport_date(rs.getDate(7));
                    book.setAvailable(rs.getBoolean(8));
                }
            }
            System.out.println(book);
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        List<Book> bookList = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(SQL_FIND_BOOK_BY_AUTHOR)) {
            pstm.setString(1, author);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setBook_id(rs.getInt(1));
                    book.setTitle(rs.getString(2));
                    book.setAuthor(rs.getString(3));
                    book.setPublisher(rs.getString(4));
                    book.setCategory(rs.getString(5));
                    book.setPrice(rs.getDouble(6));
                    book.setImport_date(rs.getDate(7));
                    book.setAvailable(rs.getBoolean(8));
                    bookList.add(book);
                }
            }
            System.out.println(bookList);
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookList;
    }

    @Override
    public List<Book> findBookByPublisher(String publisher) {
        List<Book> bookList = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(SQL_FIND_BOOK_BY_PUBLISHER)) {
            pstm.setString(1, publisher);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setBook_id(rs.getInt(1));
                    book.setTitle(rs.getString(2));
                    book.setAuthor(rs.getString(3));
                    book.setPublisher(rs.getString(4));
                    book.setCategory(rs.getString(5));
                    book.setPrice(rs.getDouble(6));
                    book.setImport_date(rs.getDate(7));
                    book.setAvailable(rs.getBoolean(8));
                    bookList.add(book);
                }
            }
            System.out.println(bookList);
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookList;
    }

    @Override
    public List<Book> findBookByCategory(String category) {
        List<Book> bookList = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(SQL_FIND_BOOK_BY_CATEGORY)) {
            pstm.setString(1, category);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setBook_id(rs.getInt(1));
                    book.setTitle(rs.getString(2));
                    book.setAuthor(rs.getString(3));
                    book.setPublisher(rs.getString(4));
                    book.setCategory(rs.getString(5));
                    book.setPrice(rs.getDouble(6));
                    book.setImport_date(rs.getDate(7));
                    book.setAvailable(rs.getBoolean(8));
                    bookList.add(book);
                }
            }
            System.out.println(bookList);
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookList;
    }

    @Override
    public List<Book> findBookWithPriceIn(double lessPrice, double greaterPrice) {
        List<Book> bookList = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(SQL_FIND_BOOK_WITH_PRICE_IN)) {
            pstm.setDouble(1, lessPrice);
            pstm.setDouble(2, greaterPrice);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setBook_id(rs.getInt(1));
                    book.setTitle(rs.getString(2));
                    book.setAuthor(rs.getString(3));
                    book.setPublisher(rs.getString(4));
                    book.setCategory(rs.getString(5));
                    book.setPrice(rs.getDouble(6));
                    book.setImport_date(rs.getDate(7));
                    book.setAvailable(rs.getBoolean(8));
                    bookList.add(book);
                }
            }
            System.out.println(bookList);
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookList;
    }
}
