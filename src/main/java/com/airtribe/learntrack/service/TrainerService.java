package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Trainer;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.TrainerRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class TrainerService implements TrainerRepository {

    private final List<Trainer> trainerList = new ArrayList<>();

    @Override
    public Trainer addTrainer(String fName, String lName, String email) {
        int personId = IdGenerator.getNextPersonId();
        Trainer newTrainer = new Trainer(personId, fName, lName, email);
        trainerList.add(newTrainer);
        System.out.println("Trainer Added: " + newTrainer.getfName());
        return newTrainer;
    }

    public Trainer findTrainerById(int trainerId) {
        for (Trainer trainer : trainerList) {
            if (trainer.getId() == trainerId) {
                return trainer;
            }
        }
        throw new EntityNotFoundException("Trainer with ID " + trainerId + " not found.");
    }

    @Override
    public Trainer removeTrainer(int trainerID) {
        Trainer trainerToRemove = findTrainerById(trainerID);
        trainerList.remove(trainerToRemove);
        System.out.println("Successfully removed trainer: " + trainerToRemove.getfName());
        return trainerToRemove;
    }

    @Override
    public Trainer updateTrainer(int trainerID, String newEmail) {
        Trainer trainerToUpdate = findTrainerById(trainerID);
        trainerToUpdate.setEmail(newEmail);
        System.out.println("Trainer " + trainerToUpdate.getfName() + " updated.");
        return trainerToUpdate;
    }

    @Override
    public List<Trainer> listTrainer() {
        return trainerList;
    }
}
