import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        final int MIN_PARK_TEMP = 70;
        final int MIN_POOL_TEMP = 85;
        final int MAX_POOL_TEMP = 90;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value: ");
        int fahrenheit = input.nextInt();
        System.out.print("Enter a day of the week: ");
        String day = input.next();
        double celsius = (5D / 9) * (fahrenheit - 32);

        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.printf("%s %.1f \n", day + " Celsius: ", celsius);

        if ((fahrenheit >= MIN_POOL_TEMP) && (fahrenheit <= MAX_POOL_TEMP)) {
            System.out.println("Go to the swimming pool");
        } else if ((fahrenheit < MIN_POOL_TEMP) && (fahrenheit >= MIN_PARK_TEMP)) {
            System.out.println("Go to the park.");
        } else {
            System.out.println("Stay at home.");
        }

        System.out.println("Bye!");
    }
}
