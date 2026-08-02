package spring.coding.service;

import spring.coding.entity.Enrollment;
import spring.coding.entity.Status;
import spring.coding.exception.EntityNotFoundException;
import spring.coding.repository.EnrollmentRepository;
import spring.coding.util.IdGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnrollmentService implements EnrollmentRepository {

    private final List<Enrollment> enrollmentList = new ArrayList<>();

    @Override
    public Enrollment addEnrollment(int id, int enrollmentID, int studentID, Date enrollmentDate, Status stats) {
        int newEnrollmentId = IdGenerator.getNextEnrollmentId();
        Enrollment newEnrollment = new Enrollment(newEnrollmentId, newEnrollmentId, studentID, enrollmentDate, stats);
        enrollmentList.add(newEnrollment);
        System.out.println("Enrollment Added for Student ID: " + newEnrollment.getStudentID());
        return newEnrollment;
    }

    public Enrollment findEnrollmentById(int enrollmentID) {
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getEnrollmentID() == enrollmentID) {
                return enrollment;
            }
        }
        throw new EntityNotFoundException("Enrollment with ID " + enrollmentID + " not found.");
    }

    @Override
    public Enrollment removeEnrollment(int enrollmentID) {
        Enrollment enrollmentToRemove = findEnrollmentById(enrollmentID);
        enrollmentList.remove(enrollmentToRemove);
        System.out.println("Successfully removed enrollment: " + enrollmentToRemove.getEnrollmentID());
        return enrollmentToRemove;
    }

    @Override
    public Enrollment updateEnrollment(int enrollmentID, int studentID, Date enrollmentDate, Status stats) {
        Enrollment enrollmentToUpdate = findEnrollmentById(enrollmentID);
        enrollmentToUpdate.setStudentID(studentID);
        enrollmentToUpdate.setEnrollmentDate(enrollmentDate);
        enrollmentToUpdate.setStatus(stats);
        System.out.println("Enrollment " + enrollmentToUpdate.getEnrollmentID() + " updated.");
        return enrollmentToUpdate;
    }

    @Override
    public List<Enrollment> listEnrollment() {
        return enrollmentList;
    }

    public void updateEnrollmentStatus(int enrollmentId, Status newStatus) {
        Enrollment enrollmentToUpdate = findEnrollmentById(enrollmentId);
        enrollmentToUpdate.setStatus(newStatus);
        System.out.println("Enrollment status updated to: " + newStatus);
    }
}
