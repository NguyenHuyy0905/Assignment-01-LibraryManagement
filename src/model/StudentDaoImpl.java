package model;

import dao.DBConnection;
import entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDaoImpl implements StudentDao{
    private final Connection conn = DBConnection.createConnection();
    private final String SQL_CREATE_STUDENT = "INSERT INTO students (name, student_code) VALUES (?, ?);";
    private final String SQL_GET_STUDENT_BY_ID = "SELECT * FROM students WHERE student_id = ?;";
    private final String SQL_GET_ALL_STUDENTS = "SELECT * FROM students";
    private final String SQL_DELETE_STUDENT_BY_ID = "DELETE FROM students WHERE student_id = ?;";
    @Override
    public void createStudent(Student student) {
        try (PreparedStatement pstm = conn.prepareStatement(SQL_CREATE_STUDENT, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, student.getName());
            pstm.setString(2, student.getStudent_code());
            pstm.executeUpdate();
            try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    student.setStudent_id(generatedKeys.getInt(1));
                }
            }
            System.out.println("Thêm mới sinh viên thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Student getStudentById(int id) {
        Student student = new Student();
        try (PreparedStatement pstm = conn.prepareStatement(SQL_GET_STUDENT_BY_ID)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    student.setStudent_id(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setStudent_code(rs.getString(3));
                }
            }
            System.out.println(student);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(SQL_GET_ALL_STUDENTS);
            ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setStudent_id(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setStudent_code(rs.getString(3));
                studentList.add(student);
            }
            System.out.println(studentList);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentList;
    }

    @Override
    public void deleteStudentById(int id) {
        try (PreparedStatement pstm = conn.prepareStatement(SQL_DELETE_STUDENT_BY_ID)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
            System.out.println("Xóa sinh viên thành công !");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
