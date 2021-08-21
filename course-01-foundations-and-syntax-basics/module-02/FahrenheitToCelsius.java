import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value and press \"Enter\": ");
        int fahrenheit = input.nextInt();

        // We must "clean up" the trailing new line before processing
        // the input that follows.
        input.nextLine();

        System.out.print("Enter a day of the week and press \"Enter\": ");
        String day = input.next();

        System.out.print("Enter your preferred Celsius label and press \"Enter\": ");
        String cText = input.next();
        cText = cText + ":";

        double celsius = (5D / 9) * (fahrenheit - 32);
        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.println(day + " Celcius: " + celsius);
    }
}
