package controller;

import entity.Student;
import model.StudentDao;
import model.StudentDaoImpl;

import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    public void createStudent(Student student) {
        studentDao.createStudent(student);
    }
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
    public void deleteStudentById(int id) {
        studentDao.deleteStudentById(id);
    }
}
