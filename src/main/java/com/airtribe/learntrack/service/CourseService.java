package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseRepository {

    private final List<Course> courses = new ArrayList<>();

    @Override
    public Course addCourse(String courseName, int courseId, String courseDescription, int courseDurationinWeeks, boolean active) {
        int newCourseId = IdGenerator.getNextCourseId();
        Course newCourse = new Course(courseName, newCourseId, courseDescription, courseDurationinWeeks, active);
        courses.add(newCourse);
        System.out.println("Course Added: " + newCourse.getCourseName());
        return newCourse;
    }

    public Course findCourseById(int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        throw new EntityNotFoundException("Course with ID " + courseId + " not found.");
    }

    @Override
    public Course activateCourse(int courseId) {
        Course courseToActivate = findCourseById(courseId);
        courseToActivate.setActive(true);
        System.out.println("Course " + courseToActivate.getCourseName() + " activated.");
        return courseToActivate;
    }

    @Override
    public Course deactivateCourse(int courseId) {
        Course courseToDeactivate = findCourseById(courseId);
        courseToDeactivate.setActive(false);
        System.out.println("Course " + courseToDeactivate.getCourseName() + " deactivated.");
        return courseToDeactivate;
    }

    @Override
    public Course updateCourse(int courseId, String courseDescription, int courseDurationinWeeks, boolean active) {
        Course courseToUpdate = findCourseById(courseId);
        courseToUpdate.setCourseDescription(courseDescription);
        courseToUpdate.setCourseDurationinWeeks(courseDurationinWeeks);
        courseToUpdate.setActive(active);
        System.out.println("Course " + courseToUpdate.getCourseName() + " updated.");
        return courseToUpdate;
    }

    @Override
    public List<Course> listCourse() {
        return courses;
    }
}
