package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.exception.InvalidBoundaryException;
import com.airtribe.learntrack.exception.InvalidInputException;

import java.util.Date;

public class Enrollment {
    private int id;
    private int enrollmentID;
    private int studentID;
    private Date enrollmentDate;
    private Status status;

    public Enrollment(int id, int enrollmentID, int studentID, Date enrollmentDate, Status status) {
        this.setId(id);
        this.setEnrollmentID(enrollmentID);
        this.setStudentID(studentID);
        this.setEnrollmentDate(enrollmentDate);
        this.setStatus(status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new InvalidBoundaryException("ID must be a positive number.");
        }
        this.id = id;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        if (enrollmentID <= 0) {
            throw new InvalidBoundaryException("Enrollment ID must be a positive number.");
        }
        this.enrollmentID = enrollmentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        if (studentID <= 0) {
            throw new InvalidBoundaryException("Student ID must be a positive number.");
        }
        this.studentID = studentID;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        if (enrollmentDate == null) {
            throw new InvalidInputException("Enrollment date cannot be null.");
        }
        this.enrollmentDate = enrollmentDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null) {
            throw new InvalidInputException("Status cannot be null.");
        }
        this.status = status;
    }
}
