package spring.coding.service;

import spring.coding.entity.Student;
import spring.coding.exception.EntityNotFoundException;
import spring.coding.exception.InvalidInputException;
import spring.coding.repository.StudentRepository;
import spring.coding.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public Student addStudent(String firstName, String lastName, String email, String batch) {
        if (firstName == null || firstName.isBlank()) {
            throw new InvalidInputException("First name cannot be empty.");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new InvalidInputException("Last name cannot be empty.");
        }

        int personId = IdGenerator.getNextPersonId();
        Student newStudent = new Student(personId, firstName, lastName, email, batch);
        students.add(newStudent);
        System.out.println("Student Added: " + newStudent.getfName());
        return newStudent;
    }

    public Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        // If the loop completes without finding the student, throw the exception.
        throw new EntityNotFoundException("Student with ID " + studentId + " not found.");
    }

    @Override
    public Student removeStudent(int studentId) {
        Student studentToRemove = findStudentById(studentId);
        students.remove(studentToRemove);
        System.out.println("Successfully removed student: " + studentToRemove.getfName());
        return studentToRemove;
    }

    @Override
    public Student updateStudent(int studentId, String newBatch, String newEmail) {
        Student studentToUpdate = findStudentById(studentId);
        studentToUpdate.setBatch(newBatch);
        studentToUpdate.setEmail(newEmail);
        System.out.println("Student " + studentToUpdate.getfName() + " updated.");
        return studentToUpdate;
    }

    @Override
    public List<Student> listStudents() {
        return students;
    }

    @Override
    public Student addStudentWithoutEmail(String fName, String lName, String batch) {
        return addStudent(fName, lName, null, batch);
    }
}
