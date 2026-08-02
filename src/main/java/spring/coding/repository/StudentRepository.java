package spring.coding.repository;

import spring.coding.entity.Student;

import java.util.List;

public interface StudentRepository {
    public Student addStudent(String firstName, String lastName, String email, String batch);
    public Student addStudentWithoutEmail(String fName, String lName, String batch);
    public Student removeStudent(int studentId);
    public Student updateStudent(int studentId, String newBatch, String newEmail);
    public List<Student> listStudents();
}

