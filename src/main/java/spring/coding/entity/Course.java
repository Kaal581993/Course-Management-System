package spring.coding.entity;

import spring.coding.exception.InvalidBoundaryException;
import spring.coding.exception.InvalidInputException;

public class Course {

    private String courseName;
    public static int courseId;
    private String courseDescription;
    private int courseDurationinWeeks;
    private boolean active;

    public Course(String courseName, int courseId, String courseDescription, int courseDurationinWeeks, boolean active) {
        this.setCourseName(courseName);
        this.setCourseId(courseId);
        this.setCourseDescription(courseDescription);
        this.setCourseDurationinWeeks(courseDurationinWeeks);
        this.setActive(active);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new InvalidInputException("Course name cannot be null or empty.");
        }
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        if (courseId <= 0) {
            throw new InvalidBoundaryException("Course ID must be a positive number.");
        }
        this.courseId = courseId;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription; // Description can be empty, so no validation needed
    }

    public int getCourseDurationinWeeks() {
        return courseDurationinWeeks;
    }

    public void setCourseDurationinWeeks(int courseDurationinWeeks) {
        if (courseDurationinWeeks <= 0) {
            throw new InvalidBoundaryException("Course duration must be a positive number.");
        }
        this.courseDurationinWeeks = courseDurationinWeeks;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
