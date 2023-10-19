package controller;

import entity.Book;
import entity.BorrowedBook;
import model.BorrowingDao;
import model.BorrowingDaoImpl;

import java.util.List;

public class BorriwingService {
    private BorrowingDao borrowingDao = new BorrowingDaoImpl();
    public void letStudentBorrowBook(BorrowedBook borrowedBook) {
        borrowingDao.letStudentBorrowBook(borrowedBook);
    }
    public void letStudentReturnBook(int borrow_id) {
        borrowingDao.letStudentReturnBook(borrow_id);
    }
    public List<Book> getBorrowedBooksByStudentCode(int student_id) {
        return borrowingDao.getBorrowedBooksByStudentCode(student_id);
    }
}
