public class ComparisonTest {
    public static void main(String[] args) {
        String x = "park";
        String y = "p4rk";

        // The compareTo() method compares the
        // Unicode value of the character at each index in x and y.
        // The first character is identical for both Strings. "4" has
        // a higher Unicode value than "a", so the method returns a
        // positive one. Since positive one is greater than zero, the
        // condition is true.
        if (x.compareTo(y) > 0) {
            System.out.println("x is greater than y.");
            System.out.println("x: " + x);
            System.out.println("y: " + y);
        }
    }
}
