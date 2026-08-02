package spring.coding.entity;

import spring.coding.exception.InvalidBoundaryException;
import spring.coding.exception.InvalidInputException;

public class Person {
    private int id;
    private String fName;
    private String lName;
    private String email;

    public Person() {
    }

    public Person(int id, String fName, String lName, String email) {
        // Use the setters in the constructor to ensure validation is always applied
        this.setId(id);
        this.setfName(fName);
        this.setlName(lName);
        this.setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new InvalidBoundaryException("ID must be a positive number.");
        }
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        if (fName == null || fName.trim().isEmpty()) {
            throw new InvalidInputException("First name cannot be null or empty.");
        }
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        if (lName == null || lName.trim().isEmpty()) {
            throw new InvalidInputException("Last name cannot be null or empty.");
        }
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // Email can be null, but if it's not, it should be a valid format
        if (email != null && !email.contains("@")) {
            throw new InvalidInputException("Email format is invalid.");
        }
        this.email = email;
    }

    public void getDisplayName(){
//        System.out.println("The ID is: "+id);
        System.out.println("The First Name: "+fName);
        System.out.println("The Last Name: "+lName);
//        System.out.println("The email id: "+email);
    }
}
