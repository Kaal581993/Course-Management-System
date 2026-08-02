package spring.coding.handler;

import spring.coding.entity.Enrollment;
import spring.coding.entity.Status;
import spring.coding.service.EnrollmentService;
import spring.coding.ui.ConsoleUtil;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentMenuHandler {

    private final EnrollmentService enrollmentService;

    public EnrollmentMenuHandler(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    public void handle() {
        Map<Integer, Runnable> enrollmentMenuOptions = new LinkedHashMap<>();
        enrollmentMenuOptions.put(1, this::enrollStudent);
        enrollmentMenuOptions.put(2, this::updateEnrollmentStatus);
        enrollmentMenuOptions.put(3, this::viewAllEnrollments);

        ConsoleUtil.runMenu("--- Enrollment Management ---", enrollmentMenuOptions, false);
    }

    private void enrollStudent() {
        int studentId = ConsoleUtil.getIntInput("Enter Student ID: ");
        enrollmentService.addEnrollment(1, 1, studentId, new Date(), Status.ACTIVE);
        System.out.println("Enrollment successful!");
    }

    private void updateEnrollmentStatus() {
        int enrollmentId = ConsoleUtil.getIntInput("Enter the ID of the enrollment to update: ");
        System.out.println("Select new status:");
        System.out.println("1. COMPLETED");
        System.out.println("2. CANCELLED");
        int statusChoice = ConsoleUtil.getIntInput("Enter choice: ");

        Status newStatus;
        if (statusChoice == 1) {
            newStatus = Status.COMPLETED;
        } else if (statusChoice == 2) {
            newStatus = Status.CANCELLED;
        } else {
            System.out.println("Invalid status choice.");
            return;
        }

        enrollmentService.updateEnrollmentStatus(enrollmentId, newStatus);
    }

    private void viewAllEnrollments() {
        System.out.println("\n--- All Enrollments ---");
        List<Enrollment> allEnrollments = enrollmentService.listEnrollment();
        if (allEnrollments.isEmpty()) {
            System.out.println("No enrollments found.");
        } else {
            allEnrollments.forEach(e ->
                    System.out.printf("Enrollment ID: %d, Student ID: %d, Date: %s, Status: %s\n",
                            e.getEnrollmentID(), e.getStudentID(), e.getEnrollmentDate(), e.getStatus())
            );
        }
    }
}
