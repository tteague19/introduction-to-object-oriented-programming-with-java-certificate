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

        boolean raining;
        System.out.print("Is it raining? (y/n): ");
        String rainInput = input.next().toLowerCase();
        raining = rainInput.startsWith("y") ? true : false;

        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.printf("%s %.1f \n", day + " Celsius: ", celsius);


        if ((fahrenheit >= MIN_POOL_TEMP) && (fahrenheit <= MAX_POOL_TEMP)) {

            if (raining) {
                System.out.println("Bummer! The pool is closed due to the rain.");
            } else {
                System.out.println("Yay! It's at least "
                                + MIN_POOL_TEMP
                                + " degrees but under "
                                + MAX_POOL_TEMP
                                + ".");
                System.out.println("Time to go to the pool.");
            }

        } else if ((fahrenheit < MIN_POOL_TEMP) && (fahrenheit >= MIN_PARK_TEMP)) {

            if (raining) {
                System.out.println("If you go to the park, bring an umbrella!");
            } else {
                System.out.println("Yay! It's at least "
                                    + MIN_PARK_TEMP
                                    + " degrees but under "
                                    + MIN_POOL_TEMP
                                    + ".");
                System.out.println("Time to go to the park.");
            }
        } else {
            if (raining) {
                System.out.println("Stay inside where it is dry.");
            } else {
                System.out.println("Stay inside where it is comfortable.");
            }
        }

        System.out.println("Bye!");
    }
}
