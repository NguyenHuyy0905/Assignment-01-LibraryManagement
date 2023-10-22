package ui;

import controller.BookService;
import controller.BorrowingService;
import controller.StudentService;
import entity.Book;
import entity.BorrowedBook;
import entity.Student;

import java.util.List;
import java.util.Scanner;

public class LibraryConsole {
    private final Scanner sc;
    private BookService bookService = new BookService();
    private BorrowingService borrowingService = new BorrowingService();
    private StudentService studentService = new StudentService();
    public LibraryConsole() {
        this.sc = new Scanner(System.in);
    }
    private int mainMenu() {
        System.out.println("---LIBRARY MENU---");
        System.out.println("1. Nhập sách mới, Xóa sách");
        System.out.println("2. Nhập sinh viên mới, Xóa sinh viên");
        System.out.println("3. Tìm kiếm phân loại sách");
        System.out.println("4. Cho sinh viên mượn, trả sách");
        System.out.println("5. Hiển thị ds những sách mà sv đã mượn (theo msv)");
        System.out.println("0. Exit");
        int choice = readInt(0, 5);
        return choice;
    }
    private int menu1() {
        System.out.println("---Tạo & Xóa Sách---");
        System.out.println("1. Nhập sách mới");
        System.out.println("2. Xóa sách");
        System.out.println("0. Exit");
        int choice = readInt(0, 2);
        return choice;
    }
    private int menu2() {
        System.out.println("---Tạo & Xóa Sinh viên---");
        System.out.println("1. Tạo mới sinh viên");
        System.out.println("2. Tìm sinh viên theo id");
        System.out.println("3. Tìm tất cả sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.println("0. Exit");
        int choice = readInt(0, 4);
        return choice;
    }
    private int menu3() {
        System.out.println("---Sách---");
        System.out.println("1. Hiển thị tất cả đầu sách");
        System.out.println("2. Tìm sách theo Id");
        System.out.println("3. Tìm sách theo Tên sách");
        System.out.println("4. Tìm sách theo Tác giả");
        System.out.println("5. Tìm sách theo NXB");
        System.out.println("6. Tìm sách theo Thể loại");
        System.out.println("7. Tìm sách theo Khoảng giá");
        System.out.println("0. Exit");
        int choice = readInt(0, 7);
        return choice;
    }
    private int menu4() {
        System.out.println("---BORROW & RETURN---");
        System.out.println("1. Cho sinh viên mượn sách");
        System.out.println("2. Cho sinh trả sách");
        System.out.println("0. Exit");
        int choice = readInt(0, 2);
        return choice;
    }
    public void start() {
        while (true) {
            int choice = mainMenu();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    boolean flag_1 = false;
                    while (!flag_1) {
                        int choice_1 = menu1();
                        switch (choice_1) {
                            case 0:
                                flag_1 = true;
                                break;
                            case 1:
                                createBook();
                                break;
                            case 2:
                                deleteBook();
                                break;
                            default:
                                throw new AssertionError();
                        }
                    }
                    break;
                case 2:
                    boolean flag_2 = false;
                    while (!flag_2) {
                        int choice_2= menu2();
                        switch (choice_2) {
                            case 0:
                                flag_2 = true;
                                break;
                            case 1:
                                createStudent();
                                break;
                            case 2:
                                getStudentById();
                                break;
                            case 3:
                                getAllStudents();
                                break;
                            case 4:
                                deleteStudentById();
                                break;
                            default:
                                throw new AssertionError();
                        }
                    }
                    break;
                case 3:
                    boolean flag_3 = false;
                    while (!flag_3) {
                        int choice_3 = menu3();
                        switch (choice_3) {
                            case 0:
                                flag_3 = true;
                                break;
                            case 1:
                                getAllBooks();
                                break;
                            case 2:
                                findBookById();
                                break;
                            case 3:
                                findBookByTitle();
                                break;
                            case 4:
                                findBookByAuthor();
                                break;
                            case 5:
                                findBookByPublisher();
                                break;
                            case 6:
                                findBookByCategory();
                                break;
                            case 7:
                                findBookWithPriceIn();
                                break;
                            default:
                                throw new AssertionError();
                        }
                    }
                    break;
                case 4:
                    boolean flag_4 = false;
                    while (!flag_4) {
                        int choice_4 = menu4();
                        switch (choice_4) {
                            case 0:
                                flag_4 = true;
                                break;
                            case 1:
                                letStudentBorrowBook();
                                break;
                            case 2:
                                letStudentReturnBook();
                                break;
                            default:
                                throw new AssertionError();
                        }
                    }
                    break;
                case 5:
                    getBorrowedBooksByStudentCode();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    private int readInt(int min, int max) {
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                }
            } catch (NumberFormatException ex) {

            }
        }
        return choice;
    }
    private double readDouble(int min, double max) {
        double price = 0;
        while (true) {
            try {
                price = Double.parseDouble(sc.nextLine());
                if (price >= min && price <= max) {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid value. Try to enter a float value");
            }
        }
        return price;
    }
    public void createBook() {
        System.out.println("Nhập tên sách: ");
        String title = sc.nextLine();
        System.out.println("Nhập tên tác giả: ");
        String author = sc.nextLine();
        System.out.println("Nhập tên NXB: ");
        String publisher = sc.nextLine();
        System.out.println("Nhập thể loại sách: ");
        String category = sc.nextLine();
        System.out.println("Nhập giá sách: ");
        double price = readDouble(0, Double.MAX_VALUE);
        Book book = new Book(title, author, publisher, category, price);
        bookService.createBook(book);
    }
    public void deleteBook() {
        System.out.println("Nhập id của sách: ");
        int id = Integer.parseInt(sc.nextLine());
        bookService.deleteBookById(id);
    }
    public void getAllBooks() {
        bookService.getAllBooks();
    }
    public void findBookById() {
        System.out.println("Nhập id của sách: ");
        int id = Integer.parseInt(sc.nextLine());
        bookService.findBookById(id);
    }
    public void findBookByTitle() {
        System.out.println("Nhập tên sách: ");
        String title = sc.nextLine();
        bookService.findBookByTitle(title);
    }
    public void findBookByAuthor() {
        System.out.println("Nhập tên tác giả: ");
        String author = sc.nextLine();
        bookService.findBookByAuthor(author);
    }
    public void findBookByPublisher() {
        System.out.println("Nhập tên NXB: ");
        String publisher = sc.nextLine();
        bookService.findBookByPublisher(publisher);
    }
    public void findBookByCategory() {
        System.out.println("Nhập thể loại: ");
        String category = sc.nextLine();
        bookService.findBookByCategory(category);
    }
    public void findBookWithPriceIn() {
        System.out.println("Nhập giá sách nhỏ: ");
        double lessPrice = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập giá sách lớn: ");
        double greaterPrice = Double.parseDouble(sc.nextLine());
        bookService.findBookWithPriceIn(lessPrice, greaterPrice);
    }
    public void letStudentBorrowBook() {
        System.out.println("Nhập id của sinh viên: ");
        int student_id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập id của sách: ");
        int book_id = Integer.parseInt(sc.nextLine());
        BorrowedBook borrowedBook = new BorrowedBook(student_id, book_id);
        borrowingService.letStudentBorrowBook(borrowedBook);
    }
    public void letStudentReturnBook() {
        System.out.println("Nhập id của lần mượn sách: ");
        int borrow_id = Integer.parseInt(sc.nextLine());
        borrowingService.letStudentReturnBook(borrow_id);
    }
    public void getBorrowedBooksByStudentCode() {
        System.out.println("Nhập mã sinh viên: ");
        String student_code = sc.nextLine();
        borrowingService.getBorrowedBooksByStudentCode(student_code);
    }
    public void createStudent() {
        System.out.println("Nhập tên sinh viên: ");
        String name = sc.nextLine();
        System.out.println("Nhập mã sinh viên: ");
        String student_code = sc.nextLine();
        Student student = new Student(name, student_code);
        studentService.createStudent(student);
    }
    public void getStudentById() {
        System.out.println("Nhập id sinh viên: ");
        int id = Integer.parseInt(sc.nextLine());
        studentService.getStudentById(id);
    }
    public void getAllStudents() {
        studentService.getAllStudents();
    }
    public void deleteStudentById() {
        System.out.println("Nhập id sinh viên: ");
        int id = Integer.parseInt(sc.nextLine());
        studentService.deleteStudentById(id);
    }
}
