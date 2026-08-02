package spring.coding.handler;

import spring.coding.entity.Trainer;
import spring.coding.service.TrainerService;
import spring.coding.ui.ConsoleUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TrainerMenuHandler {

    private final TrainerService trainerService;

    public TrainerMenuHandler(TrainerService trainerService) {
        this.trainerService = trainerService;
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
        trainerService.addTrainer(fName, lName, email);
        System.out.println("Trainer added successfully!");
    }

    private void viewAllTrainers() {
        System.out.println("\n--- All Trainers ---");
        List<Trainer> allTrainers = trainerService.listTrainer();
        if (allTrainers.isEmpty()) {
            System.out.println("No trainers found.");
        } else {
            allTrainers.forEach(t ->
                    System.out.printf("ID: %d, Name: %s %s\n", t.getId(), t.getfName(), t.getlName())
            );
        }
    }
}
