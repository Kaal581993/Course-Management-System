# LearnTrack: Environment Setup Instructions

This document outlines the steps to set up the Java Development Kit (JDK) and run the LearnTrack application.

## 1. JDK Installation

To compile and run this project, you need to have the Java Development Kit (JDK) installed.

### JDK Version Used
*   **JDK Version**: 11 (or higher is recommended, e.g., JDK 17)

### Installation Steps
1.  **Download**: Download the JDK from a vendor like [Oracle](https://www.oracle.com/java/technologies/downloads/) or the open-source [OpenJDK](https://jdk.java.net/).
2.  **Install**: Follow the installation instructions for your operating system (Windows, macOS, or Linux).
3.  **Set Environment Variables**:
    *   Set the `JAVA_HOME` environment variable to point to your JDK installation directory.
    *   Add the JDK's `bin` folder to your system's `PATH` variable.
4.  **Verify Installation**: Open a new terminal or command prompt and run the following commands:
    ```sh
    java -version
    javac -version
    ```
    Both commands should display the installed JDK version.

## 2. Running the "Hello World" Program

Here is a screenshot showing a basic "Hello World" program being compiled and run from the terminal, confirming the JDK is configured correctly.

*(You can replace this text with your own screenshot or explanation)*

![Hello World Screenshot](https://i.imgur.com/O8dJv2c.png)

### Steps shown above:
1.  The `HelloWorld.java` file was created with a `main` method.
2.  It was compiled using `javac HelloWorld.java`.
3.  It was run using `java HelloWorld`, which correctly printed "Hello, World!" to the console.
