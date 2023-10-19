package model;

import dao.DBConnection;
import entity.Book;
import entity.BorrowedBook;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BorrowingDaoImpl implements BorrowingDao{
    private final Connection conn = DBConnection.createConnection();
    private final String SQL_LET_STUDENT_BORROW_BOOK_1 = "INSERT INTO BorrowedBooks (student_id, book_id) VALUES (?, ?)";
    private final String SQL_LET_STUDENT_BORROW_BOOK_2 = "SELECT * FROM books WHERE book_id = ?";
    private final String SQL_LET_STUDENT_RETURN_BOOK = "DELETE FROM borrowedBooks WHERE borrow_id = ?";
    private final String SQL_GET_BORROWED_BOOK_BY_STUDENT_CODE = "SELECT b.title FROM books b WHERE b.book_id in (SELECT bb.book_id FROM borrowedbooks bb WHERE bb.student_id = ?)";
    @Override
    public void letStudentBorrowBook(BorrowedBook borrowedBook) {
        try (PreparedStatement pstm_1 = conn.prepareStatement(SQL_LET_STUDENT_BORROW_BOOK_1, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement pstm_2 = conn.prepareStatement(SQL_LET_STUDENT_BORROW_BOOK_2);
             ResultSet resultSet = pstm_2.executeQuery())
        {
            pstm_1.setInt(1, borrowedBook.getStudent_id());
            pstm_1.setInt(2, borrowedBook.getBook_id());
            pstm_1.executeUpdate();
            try (ResultSet rs_1 = pstm_1.getGeneratedKeys()) {
                while (rs_1.next()) {
                    borrowedBook.setBorrow_id(rs_1.getInt(1));
                }
            }
            while (resultSet.next()) {
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void letStudentReturnBook(int borrow_id) {

    }

    @Override
    public List<Book> getBorrowedBooksByStudentCode(int student_id) {

    }
}
