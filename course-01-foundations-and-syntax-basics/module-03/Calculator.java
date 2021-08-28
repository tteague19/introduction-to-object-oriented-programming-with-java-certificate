import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        // Sub-Task 1
        // Print out a list of operations for the user
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");

        // Prompt the user to enter an operation. This operation must
        // be processed as case-insensitive.
        // If the user enters an invalid operation, the program should
        // print the following error message and terminate gracefully.
        // Invalid input entered. Terminating...
        Scanner input = new Scanner(System.in);
        String userInput = input.next().toLowerCase();

        switch (userInput) {
            case "add":
                break;
            case "subtract":
                break;
            case "multiply":
                break;
            case "divide":
                break;
            case "alphabetize":
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
        }
    }
}
