package model;

import entity.Book;
import entity.BorrowedBook;

import java.util.List;

public interface BorrowingDao {
    public void letStudentBorrowBook(BorrowedBook borrowedBook);
    public void letStudentReturnBook(int borrow_id);
    public List<Book> getBorrowedBooksByStudentCode(int student_id);
}
