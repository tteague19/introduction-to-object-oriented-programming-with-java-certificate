import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        // Sub-Task 1
        // Print out a list of operations for the user
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");

        // Sub-Task 2
        // Prompt the user to enter an operation. This operation must
        // be processed as case-insensitive.
        // If the user enters an invalid operation, the program should
        // print the following error message and terminate gracefully.
        // Invalid input entered. Terminating...
        Scanner input = new Scanner(System.in);
        String userInput = input.next().toLowerCase();
        String errorMessage = "Invalid input entered. Terminating...";

        // Sub-Task 3
        // Perform the chosen operation and print the correct output.
        // If the user is performing an add/subtract operation, prompt
        // the user to enter two integers.
        // If the user is performing a multiply/divide operation,
        // prompt the user to enter two doubles.
        // If the user is performing an alphabetize operation, prompt
        // the user to enter two words.
        // If the user inputs an invalid type (e.g. inputs doubles for
        // add/subtract) for the given operation, print the same error
        // message shown above.
        String firstInput;
        String secondInput;
        int firstInputAsInt;
        int secondInputAsInt;
        double secondInputAsDouble;
        double firstInputAsDouble;

        switch (userInput) {
            case "add":
                System.out.println("Enter two integers:");
                firstInput = input.next();
                secondInput = input.next();

                try
                {
                    firstInputAsInt = Integer.parseInt(firstInput);
                    secondInputAsInt = Integer.parseInt(secondInput);

                    int sum = firstInputAsInt + secondInputAsInt;
                    System.out.println("Answer: " + sum);

                } catch(Exception exception) {
                    System.out.println(errorMessage);
                }

                break;
            case "subtract":
                System.out.println("Enter two integers:");
                firstInput = input.next();
                secondInput = input.next();

                try
                {
                    firstInputAsInt = Integer.parseInt(firstInput);
                    secondInputAsInt = Integer.parseInt(secondInput);

                    int difference = firstInputAsInt - secondInputAsInt;
                    System.out.println("Answer: " + difference);

                } catch(Exception exception) {
                    System.out.println(errorMessage);
                }

                break;
            case "multiply":
                System.out.println("Enter two doubles:");
                firstInput = input.next();
                secondInput = input.next();

                try
                {
                    firstInputAsDouble = Double.parseDouble(firstInput);
                    secondInputAsDouble = Double.parseDouble(secondInput);

                    double product = firstInputAsDouble * secondInputAsDouble;
                    System.out.printf("Answer: %.2f\n", product);
                } catch(Exception e) {
                    System.out.println(errorMessage);
                }

                break;
            case "divide":
                System.out.println("Enter two doubles:");
                firstInput = input.next();
                secondInput = input.next();

                try
                {
                    firstInputAsDouble = Double.parseDouble(firstInput);
                    secondInputAsDouble = Double.parseDouble(secondInput);

                    if (secondInputAsDouble == 0.0) {
                        System.out.println(errorMessage);
                    } else {
                        double quotient = firstInputAsDouble / secondInputAsDouble;
                        System.out.printf("Answer: %.2f\n", quotient);
                    }

                } catch(Exception e) {
                    System.out.println(errorMessage);
                }

                break;
            case "alphabetize":
                break;
            default:
                System.out.println(errorMessage);
                break;
        }
    }
}
