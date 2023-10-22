package entity;

public class Student {
    private int student_id;
    private String name;
    private String student_code;

    public Student() {}

    public Student(String name, String student_code) {
        this.name = name;
        this.student_code = student_code;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    @Override
    public String toString() {
        return "Sinh viên {" +
                "id: " + student_id +
                ", tên sv: '" + name + '\'' +
                ", mã sv: '" + student_code + '\'' +
                '}';
    }
}
