package spring.coding.repository;

import spring.coding.entity.Trainer;

import java.util.List;

public interface TrainerRepository {

    public Trainer addTrainer(String fName, String lName, String email);
    public Trainer removeTrainer(int trainerID);
    public Trainer updateTrainer(int trainerID, String newEmail);
    public List<Trainer> listTrainer();



}
