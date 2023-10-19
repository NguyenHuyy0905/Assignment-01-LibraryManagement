package model;

import entity.Student;

import java.util.List;

public interface StudentDao {
    public void createStudent(Student student); // Thêm sinh viên
    public Student getStudentById(int id); // Lấy sinh viên theo Id
    public List<Student> getAllStudents(); // Lấy tất cả sinh viên
    public void deleteStudentById(int id); // Xóa sinh viên
}
