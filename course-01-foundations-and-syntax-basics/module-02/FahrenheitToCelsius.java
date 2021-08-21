import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value and press \"Enter\": ");
        int fahrenheit = input.nextInt();
        double celsius = (5D / 9) * (fahrenheit - 32);
        System.out.println("Celcius: " + celsius);
    }
}
