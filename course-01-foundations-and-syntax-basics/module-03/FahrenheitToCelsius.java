import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value: ");
        int fahrenheit = input.nextInt();
        System.out.print("Enter a day of the week: ");
        String day = input.next();
        double celsius = (5D / 9) * (fahrenheit - 32);
        System.out.printf("%s %.1f \n", day + " Celsius: ", celsius);
        if (fahrenheit > 70) {
            System.out.println("Yay! Go to the park.");
        }
    }
}
