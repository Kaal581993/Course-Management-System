package com.airtribe.learntrack.entity;

public class Trainer extends Person{
    private int trainerID;
    private int id;



    public Trainer(int id, String fName, String lName, String email) {
        super(id, fName, lName, email);
    }

    @Override
    public void getDisplayName(){
//        System.out.println("The ID is: "+id);
        System.out.println("The First Name: "+super.getfName());
        System.out.println("The Last Name: "+super.getlName());
//        System.out.println("The email id: "+email);
    }


    public int getTrainerID() {
        return trainerID;
    }
}
