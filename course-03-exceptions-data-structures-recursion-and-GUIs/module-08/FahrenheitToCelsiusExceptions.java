import java.util.Scanner;
import java.util.InputMismatchException;

public class FahrenheitToCelsiusExceptions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean success = false;
        int fahrenheit = 0;

        while (!success) {
            try {
                System.out.print("Enter a Fahrenheit value: ");
                fahrenheit = input.nextInt();
                success = true;
                }
            catch(InputMismatchException e) {
                System.out.println("Sorry, that wasn't an int");
                System.out.println("Please try again.");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
            finally {
                // We must clear the input buffer to prepare for the
                // next iteration of the while loop as well as the
                // step in which we capture a day of the week.
                input.nextLine();
            }
        }

        System.out.print("Enter a day of the week: ");
        String day = input.nextLine();
        double celsius = (5D / 9) * (fahrenheit - 32);
        System.out.printf("%s Fahrenheit: %d\n", day, fahrenheit);
        System.out.printf("%s Celsius:  %.1f\n", day, celsius);

    }
}
