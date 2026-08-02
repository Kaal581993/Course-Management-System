package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Status;

import java.util.Date;
import java.util.List;

public interface EnrollmentRepository {
    public Enrollment addEnrollment(int id, int enrollmentID, int studentID, Date enrollmentDate, Status stats);
    public Enrollment removeEnrollment(int enrollmentID);
    public Enrollment updateEnrollment(int enrollmentID, int studentID, Date enrollmentDate, Status stats);
    public List<Enrollment> listEnrollment();
}
