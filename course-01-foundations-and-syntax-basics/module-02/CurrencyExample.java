import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class CurrencyExample {
    public static void main(String[] args) {
        int numItems;
        double itemCost;
        double total;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        numItems = input.nextInt();
        System.out.print("Enter the cost per item: ");
        itemCost = input.nextDouble();
        total = numItems * itemCost;
        System.out.println();
        System.out.println("Unformatted Total: " + total);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Formatted Total: " + currencyFormat.format(total));
    }
}
