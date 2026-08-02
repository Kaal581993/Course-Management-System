# LearnTrack - Student & Course Management System

LearnTrack is a console-based management system built with Core Java. It allows administrators to manage students, courses, and enrollments through a simple command-line interface. This project is designed to reinforce fundamental Java and OOP principles.

## Project Description

This application provides functionalities for managing educational records. Key features include:
- **Student Management**: Add, remove, update, and list students.
- **Course Management**: Manage course information.
- **Enrollment Management**: Enroll students in courses and track their status.

The application runs entirely in the console and uses in-memory `ArrayLists` to store data, meaning all data is reset when the application closes.

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 11 or higher.

### Steps
1.  **Clone the repository**:
    ```sh
    git clone <your-repository-url>
    ```
2.  **Navigate to the source directory**:
    ```sh
    cd Course-Management-System/src/main/java
    ```
3.  **Compile the project**:
    Use `javac` to compile all `.java` files. It's best to run this from the `java` directory to handle packages correctly.
    ```sh
    javac spring/coding/App.java spring/coding/entity/*.java spring/coding/service/*.java spring/coding/util/*.java
    ```
4.  **Run the application**:
    Execute the main class from the `java` directory.
    ```sh
    java spring.coding.App
    ```
    You should now see the main menu in your console.

## Class Diagram

*(A basic representation of the class relationships. You can generate a more detailed one with a tool like PlantUML or draw.io)*

```
[ Person ] <|-- [ Student ]
[ Person ] <|-- [ Trainer ]

[ Student ] -- "1..*" [ Enrollment ]
[ Course ]  -- "1..*" [ Enrollment ]

[ StudentService ] --> [ Student ]
[ CourseService ]  --> [ Course ]
[ EnrollmentService ] --> [ Enrollment ]

[ App ] --> [ StudentService ]
[ App ] --> [ CourseService ]
[ App ] --> [ EnrollmentService ]
```
