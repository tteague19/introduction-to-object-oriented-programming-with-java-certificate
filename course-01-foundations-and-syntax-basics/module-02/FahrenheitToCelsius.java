import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value and press \"Enter\": ");
        int fahrenheit = input.nextInt();

        // We must "clean up" the trailing new line before processing
        // the input that follows.
        input.nextLine();

        System.out.print("Enter the day of the week along with the month, day, and year: ");
        String day = input.nextLine();

        double celsius = (5D / 9) * (fahrenheit - 32);
        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.println(day + " Celcius: " + celsius);
    }
}
