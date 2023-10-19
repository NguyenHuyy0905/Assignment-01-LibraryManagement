package model;

import dao.DBConnection;
import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BorrowingDaoImpl implements BorrowingDao{
    private final Connection conn = DBConnection.createConnection();
    private final String SQL_LET_STUDENT_BORROW_BOOK = "INSERT INTO BorrowedBook ()";
    private final String SQL_LET_STUDENT_RETURN_BOOK = "";
    private final String SQL_GET_BORROWED_BOOK_BY_STUDENT_CODE = "";
    @Override
    public void letStudentBorrowBook(int student_id, int book_id) {
        try (PreparedStatement pstm = conn.prepareStatement(SQL_LET_STUDENT_BORROW_BOOK, Statement.RETURN_GENERATED_KEYS)) {

        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void letStudentReturnBook(int student_id, int book_id) {

    }

    @Override
    public List<Book> getBorrowedBooksByStudentCode(int student_id) {

    }
}
