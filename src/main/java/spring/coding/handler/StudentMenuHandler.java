package spring.coding.handler;

import spring.coding.entity.Student;
import spring.coding.service.StudentService;
import spring.coding.ui.ConsoleUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentMenuHandler {

    private final StudentService studentService;

    public StudentMenuHandler(StudentService studentService) {
        this.studentService = studentService;
    }

    public void handle() {
        Map<Integer, Runnable> studentMenuOptions = new LinkedHashMap<>();
        studentMenuOptions.put(1, this::addStudent);
        studentMenuOptions.put(2, this::removeStudent);
        studentMenuOptions.put(3, this::updateStudent);
        studentMenuOptions.put(4, this::viewAllStudents);

        ConsoleUtil.runMenu("--- Student Management ---", studentMenuOptions, false);
    }

    private void addStudent() {
        String fName = ConsoleUtil.getStringInput("Enter First Name: ");
        String lName = ConsoleUtil.getStringInput("Enter Last Name: ");
        String email = ConsoleUtil.getStringInput("Enter Email (or leave blank): ");
        String batch = ConsoleUtil.getStringInput("Enter Batch: ");
        if (email.isBlank()) {
            studentService.addStudentWithoutEmail(fName, lName, batch);
        } else {
            studentService.addStudent(fName, lName, email, batch);
        }
        System.out.println("Student added successfully!");
    }

    private void removeStudent() {
        int studentId = ConsoleUtil.getIntInput("Enter student ID to remove: ");
        studentService.removeStudent(studentId);
        System.out.println("Student removed successfully.");
    }

    private void updateStudent() {
        int updateId = ConsoleUtil.getIntInput("Enter student ID to update: ");
        String newBatch = ConsoleUtil.getStringInput("Enter new Batch: ");
        String newEmail = ConsoleUtil.getStringInput("Enter new Email: ");
        studentService.updateStudent(updateId, newBatch, newEmail);
        System.out.println("Student updated successfully.");
    }

    private void viewAllStudents() {
        System.out.println("\n--- All Students ---");
        List<Student> allStudents = studentService.listStudents();
        if (allStudents.isEmpty()) {
            System.out.println("No students found.");
        } else {
            allStudents.forEach(s ->
                    System.out.printf("ID: %d, Name: %s %s, Batch: %s, Email: %s\n", s.getId(), s.getfName(), s.getlName(), s.getBatch(), s.getEmail() != null ? s.getEmail() : "N/A")
            );
        }
    }
}
