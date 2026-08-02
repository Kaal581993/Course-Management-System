package spring.coding.repository;



import spring.coding.entity.Course;

import java.util.List;

//import static spring.coding.entity.Course.courseId;


public interface CourseRepository {

    public Course addCourse(String courseName,
        int courseId,
        String courseDescription,
        int courseDurationinWeeks,
        boolean active);

    public Course activateCourse(int courseId);
    public Course deactivateCourse(int courseId);
    public Course updateCourse(int courseId, String courseDescription, int courseDurationinWeeks, boolean active);
    public List<Course> listCourse();
}
