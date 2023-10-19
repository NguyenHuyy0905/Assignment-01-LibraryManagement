package entity;

import java.util.Date;

public class BorrowedBook {
    private int borrow_id;
    private int student_id;
    private int book_id;
    private Date borrow_date;
    private Date return_date;

    public BorrowedBook() {}

    public BorrowedBook(int borrow_id, int student_id, int book_id, Date borrow_date, Date return_date) {
        this.borrow_id = borrow_id;
        this.student_id = student_id;
        this.book_id = book_id;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "borrow_id=" + borrow_id +
                ", student_id=" + student_id +
                ", book_id=" + book_id +
                ", borrow_date=" + borrow_date +
                ", return_date=" + return_date +
                '}';
    }
}
