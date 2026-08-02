package spring.coding;

import spring.coding.handler.CourseMenuHandler;
import spring.coding.handler.EnrollmentMenuHandler;
import spring.coding.handler.StudentMenuHandler;
import spring.coding.handler.TrainerMenuHandler;
import spring.coding.service.CourseService;
import spring.coding.service.EnrollmentService;
import spring.coding.service.StudentService;
import spring.coding.service.TrainerService;
import spring.coding.ui.ConsoleUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class App {

    // Services
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();
    private static final TrainerService trainerService = new TrainerService();

    // Handlers
    private static final StudentMenuHandler studentMenuHandler = new StudentMenuHandler(studentService);
    private static final CourseMenuHandler courseMenuHandler = new CourseMenuHandler(courseService);
    private static final EnrollmentMenuHandler enrollmentMenuHandler = new EnrollmentMenuHandler(enrollmentService);
    private static final TrainerMenuHandler trainerMenuHandler = new TrainerMenuHandler(trainerService);


    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Welcome to LearnTrack Management System  ");
        System.out.println("========================================");

        //preloadData();

        Map<Integer, Runnable> mainMenuOptions = new LinkedHashMap<>();
        mainMenuOptions.put(1, studentMenuHandler::handle);
        mainMenuOptions.put(2, courseMenuHandler::handle);
        mainMenuOptions.put(3, enrollmentMenuHandler::handle);
        mainMenuOptions.put(4, trainerMenuHandler::handle);

        // The main menu loop is now handled by the ConsoleUtil
        ConsoleUtil.runMenu("--- MAIN MENU ---", mainMenuOptions, true);

        System.out.println("Thank you for using LearnTrack. Exiting...");
        ConsoleUtil.closeScanner();
    }

    private static void preloadData() {
        try {
            studentService.addStudent("John", "Doe", "john.d@example.com", "Java Full-Stack");
            studentService.addStudent("Jane", "Smith", "jane.s@example.com", "Python Data Science");
            courseService.addCourse("Java Fundamentals", 1, "Core Java concepts", 8, true);
            courseService.addCourse("Web Development", 2, "HTML, CSS, JavaScript", 12, true);
        } catch (Exception e) {
            System.out.println("An error occurred during initial data load: " + e.getMessage());
        }        try {
            studentService.addStudent("John", "Doe", "john.d@example.com", "Java Full-Stack");
            studentService.addStudent("Jane", "Smith", "jane.s@example.com", "Python Data Science");
            courseService.addCourse("Java Fundamentals", 1, "Core Java concepts", 8, true);
            courseService.addCourse("Web Development", 2, "HTML, CSS, JavaScript", 12, true);
        } catch (Exception e) {
            System.out.println("An error occurred during initial data load: " + e.getMessage());
        }

        // Data pre-loading is currently commented out. Use this for testing purposes only
        // try {
        //     studentService.addStudent("John", "Doe", "john.d@example.com", "Java Full-Stack");
        //     studentService.addStudent("Jane", "Smith", "jane.s@example.com", "Python Data Science");
        //     courseService.addCourse("Java Fundamentals", 1, "Core Java concepts", 8, true);
        //     courseService.addCourse("Web Development", 2, "HTML, CSS, JavaScript", 12, true);
        // } catch (Exception e) {
        //     System.out.println("An error occurred during initial data load: " + e.getMessage());
        // }
    }
}
