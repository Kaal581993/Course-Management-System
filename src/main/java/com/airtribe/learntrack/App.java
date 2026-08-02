package com.airtribe.learntrack;

import com.airtribe.learntrack.handler.CourseMenuHandler;
import com.airtribe.learntrack.handler.EnrollmentMenuHandler;
import com.airtribe.learntrack.handler.StudentMenuHandler;
import com.airtribe.learntrack.handler.TrainerMenuHandler;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.repository.TrainerRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.TrainerService;
import com.airtribe.learntrack.ui.ConsoleUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class App {

    // --- INSTANCE VARIABLES ---
    // Services (the concrete implementations)
    private final StudentRepository studentService;
    private final CourseRepository courseService;
    private final EnrollmentRepository enrollmentService;
    private final TrainerRepository trainerService;

    // Handlers (the UI logic)
    private final StudentMenuHandler studentMenuHandler;
    private final CourseMenuHandler courseMenuHandler;
    private final EnrollmentMenuHandler enrollmentMenuHandler;
    private final TrainerMenuHandler trainerMenuHandler;

    /**
     * The constructor is now responsible for "wiring" the application together.
     * This is a simple form of Dependency Injection.
     */
    public App() {
        // 1. Create service instances
        this.studentService = new StudentService();
        this.courseService = new CourseService();
        this.enrollmentService = new EnrollmentService();
        this.trainerService = new TrainerService();

        // 2. Create handler instances, injecting the services (as repository interfaces)
        this.studentMenuHandler = new StudentMenuHandler(this.studentService);
        this.courseMenuHandler = new CourseMenuHandler(this.courseService);
        this.enrollmentMenuHandler = new EnrollmentMenuHandler(this.enrollmentService);
        this.trainerMenuHandler = new TrainerMenuHandler(this.trainerService);
    }

    /**
     * The main entry point of the application.
     * Its only job is to create an instance of the App and run it.
     */
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    /**
     * The main run loop of the application instance.
     */
    public void run() {
        System.out.println("========================================");
        System.out.println("  Welcome to LearnTrack Management System  ");
        System.out.println("========================================");

        preloadData();

        Map<Integer, Runnable> mainMenuOptions = new LinkedHashMap<>();
        mainMenuOptions.put(1, studentMenuHandler::handle);
        mainMenuOptions.put(2, courseMenuHandler::handle);
        mainMenuOptions.put(3, enrollmentMenuHandler::handle);
        mainMenuOptions.put(4, trainerMenuHandler::handle);

        ConsoleUtil.runMenu("--- MAIN MENU ---", mainMenuOptions, true);

        System.out.println("Thank you for using LearnTrack. Exiting...");
        ConsoleUtil.closeScanner();
    }

    /**
     * Pre-loads some sample data for testing.
     */
    private void preloadData() {
        try {
            studentService.addStudent("John", "Doe", "john.d@example.com", "Java Full-Stack");
            studentService.addStudent("Jane", "Smith", "jane.s@example.com", "Python Data Science");
            courseService.addCourse("Java Fundamentals", 1, "Core Java concepts", 8, true);
            courseService.addCourse("Web Development", 2, "HTML, CSS, JavaScript", 12, true);
        } catch (Exception e) {
            System.out.println("An error occurred during initial data load: " + e.getMessage());
        }
    }
}
