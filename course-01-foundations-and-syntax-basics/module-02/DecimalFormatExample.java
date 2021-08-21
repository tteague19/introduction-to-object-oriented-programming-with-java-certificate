import java.text.DecimalFormat;

public class DecimalFormatExample {
    public static void main(String[] args) {
        double valToFormat = .8675309;
        DecimalFormat formatter1 = new DecimalFormat("0.0");
        DecimalFormat formatter2 = new DecimalFormat("00.00");
        DecimalFormat formatter3 = new DecimalFormat(".00");
        DecimalFormat formatter4 = new DecimalFormat("0.00%");

        System.out.println("Unformatted Value: " + valToFormat);
        System.out.println("Pattern: 0.0, Output: " + formatter1.format(valToFormat));
        System.out.println("Pattern: 00.00, Output: " + formatter2.format(valToFormat));
        System.out.println("Pattern: .00, Output: " + formatter3.format(valToFormat));
        System.out.println("Pattern: 0.00%, Output: " + formatter4.format(valToFormat));
    }
}
