package spring.coding.entity;

import spring.coding.exception.InvalidInputException;

public class Student extends Person {

    private String batch;
    private boolean active;

    /**
     * Main constructor for creating a Student with all details.
     * It calls the parent constructor and its own setters to ensure validation.
     */
    public Student(int id, String fName, String lName, String email, String batch) {
        super(id, fName, lName, email);
        this.setBatch(batch);
        this.setActive(true); // By default, a new student is active.
    }

    /**
     * ===== CONSTRUCTOR OVERLOADING =====
     * A second constructor for creating a student without providing an email.
     * It calls the main constructor using `this()`, passing null for the email.
     */
    public Student(int id, String fName, String lName, String batch) {
        this(id, fName, lName, null, batch); // This calls the main constructor above
    }

    // --- Getters and Setters with Validation ---

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        if (batch == null || batch.trim().isEmpty()) {
            throw new InvalidInputException("Batch name cannot be null or empty.");
        }
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void getDisplayName() {
        System.out.println("Student Name: " + getfName() + " " + getlName());
    }
}
