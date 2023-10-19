package model;

import entity.Book;

import java.util.List;

public interface BorrowingDao {
    public void letStudentBorrowBook(int student_id, int book_id);
    public void letStudentReturnBook(int student_id, int book_id);
    public List<Book> getBorrowedBooksByStudentCode(int student_id);
}
