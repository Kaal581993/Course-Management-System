package spring.coding.handler;

import spring.coding.entity.Course;
import spring.coding.service.CourseService;
import spring.coding.ui.ConsoleUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CourseMenuHandler {

    private final CourseService courseService;

    public CourseMenuHandler(CourseService courseService) {
        this.courseService = courseService;
    }

    public void handle() {
        Map<Integer, Runnable> courseMenuOptions = new LinkedHashMap<>();
        courseMenuOptions.put(1, this::addCourse);
        courseMenuOptions.put(2, this::viewAllCourses);

        ConsoleUtil.runMenu("--- Course Management ---", courseMenuOptions, false);
    }

    private void addCourse() {
        String name = ConsoleUtil.getStringInput("Enter Course Name: ");
        String desc = ConsoleUtil.getStringInput("Enter Description: ");
        int duration = ConsoleUtil.getIntInput("Enter Duration in Weeks: ");
        courseService.addCourse(name, 0, desc, duration, true);
        System.out.println("Course added successfully!");
    }

    private void viewAllCourses() {
        System.out.println("\n--- All Courses ---");
        List<Course> allCourses = courseService.listCourse();
        if (allCourses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            allCourses.forEach(c ->
                    System.out.printf("ID: %d, Name: %s, Duration: %d weeks, Desc: %s\n", c.getCourseId(), c.getCourseName(), c.getCourseDurationinWeeks(), c.getCourseDescription())
            );
        }
    }
}
