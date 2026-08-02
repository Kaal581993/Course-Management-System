package com.airtribe.learntrack.handler;

import com.airtribe.learntrack.entity.Trainer;
import com.airtribe.learntrack.repository.TrainerRepository;
import com.airtribe.learntrack.ui.ConsoleUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TrainerMenuHandler {

    private final TrainerRepository trainerRepository;

    public TrainerMenuHandler(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void handle() {
        Map<Integer, Runnable> trainerMenuOptions = new LinkedHashMap<>();
        trainerMenuOptions.put(1, this::addTrainer);
        trainerMenuOptions.put(2, this::viewAllTrainers);

        ConsoleUtil.runMenu("--- Trainer Management ---", trainerMenuOptions, false);
    }

    private void addTrainer() {
        String fName = ConsoleUtil.getStringInput("Enter First Name: ");
        String lName = ConsoleUtil.getStringInput("Enter Last Name: ");
        String email = ConsoleUtil.getStringInput("Enter Email: ");
        trainerRepository.addTrainer(fName, lName, email);
        System.out.println("Trainer added successfully!");
    }

    private void viewAllTrainers() {
        System.out.println("\n--- All Trainers ---");
        List<Trainer> allTrainers = trainerRepository.listTrainer();
        if (allTrainers.isEmpty()) {
            System.out.println("No trainers found.");
        } else {
            allTrainers.forEach(t ->
                    System.out.printf("ID: %d, Name: %s %s\n", t.getId(), t.getfName(), t.getlName())
            );
        }
    }
}
