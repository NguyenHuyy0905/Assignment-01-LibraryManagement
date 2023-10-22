package model;

import dao.DBConnection;
import entity.Book;
import entity.BorrowedBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BorrowingDaoImpl implements BorrowingDao{
    private final Connection conn = DBConnection.createConnection();
    private final String SQL_LET_STUDENT_BORROW_BOOK = "INSERT INTO BorrowedBooks (student_id, book_id) VALUES (?, ?)";
    private final String SQL_UPDATE_STATUS_BOOK = "UPDATE books SET isAvailable = ? WHERE book_id = ?";
    private final String SQL_LET_STUDENT_RETURN_BOOK = "DELETE FROM borrowedBooks WHERE borrow_id = ?";
    private final String SQL_UPDATE_STATUS_BOOK_2 = "UPDATE books SET isAvailable = ? WHERE book_id = (SELECT book_id FROM borrowedBooks WHERE borrow_id = ?)";

    private final String SQL_GET_BORROWED_BOOK_BY_STUDENT_CODE = "SELECT b.title FROM books b WHERE b.book_id in (SELECT bb.book_id FROM borrowedbooks bb WHERE bb.student_id = ?)";
    @Override
    public void letStudentBorrowBook(BorrowedBook borrowedBook) {
        try (PreparedStatement pstm_1 = conn.prepareStatement(SQL_LET_STUDENT_BORROW_BOOK, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement pstm_2 = conn.prepareStatement(SQL_UPDATE_STATUS_BOOK))
        {
            pstm_1.setInt(1, borrowedBook.getStudent_id());
            pstm_1.setInt(2, borrowedBook.getBook_id());
            pstm_1.executeUpdate();
            try (ResultSet rs_1 = pstm_1.getGeneratedKeys()) {
                while (rs_1.next()) {
                    borrowedBook.setBorrow_id(rs_1.getInt(1));
                }
            }
            pstm_2.setInt(1, 0);
            pstm_2.setInt(2, borrowedBook.getBook_id());
            pstm_2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void letStudentReturnBook(int borrow_id) {
        try (PreparedStatement pstm_1 = conn.prepareStatement(SQL_LET_STUDENT_RETURN_BOOK);
             PreparedStatement pstm_2 = conn.prepareStatement(SQL_UPDATE_STATUS_BOOK_2))
        {
            pstm_1.setInt(1, borrow_id);
            pstm_1.executeUpdate();
            pstm_2.setInt(1, 1);
            pstm_2.setInt(2, borrow_id);
            pstm_2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Book> getBorrowedBooksByStudentCode(String student_code) {
        List<Book> bookList = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(SQL_GET_BORROWED_BOOK_BY_STUDENT_CODE)) {
            pstm.setString(1, student_code);
            try (ResultSet rs = pstm.executeQuery()) {
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
        } catch (SQLException ex) {
            Logger.getLogger(BorrowingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookList;
    }
}
