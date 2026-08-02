package spring.coding.ui;

import spring.coding.exception.EntityNotFoundException;
import spring.coding.exception.InvalidBoundaryException;
import spring.coding.exception.InvalidInputException;

import java.util.Map;
import java.util.Scanner;

public class ConsoleUtil {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * A generic, reusable method to run a menu loop.
     *
     * @param title      The title of the menu.
     * @param options    A map where the key is the menu number and the value is the action to perform.
     * @param isMainMenu A flag to determine if this is the main exit point of the app.
     */
    public static void runMenu(String title, Map<Integer, Runnable> options, boolean isMainMenu) {
        int choice;
        do {
            System.out.println("\n" + title);
            options.forEach((key, action) -> {
                // A simple way to create a label from the Runnable's implementation class
                String actionName = action.getClass().getSimpleName().replace("$$Lambda$", " ").split("/")[0];
                System.out.printf("%d. %s\n", key, actionName);
            });
            System.out.printf("0. %s\n", isMainMenu ? "Exit" : "Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = getIntInput("Enter Duration in Weeks: ");

            try {
                if (options.containsKey(choice)) {
                    options.get(choice).run();
                } else if (choice != 0) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (EntityNotFoundException | InvalidInputException | InvalidBoundaryException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);
    }

    public static int getIntInput(String s) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static void closeScanner() {
        sc.close();
    }
}
