public class StringEquality {
    public static void main(String[] args) {

        // This choice of assignments will trigger the second if-statement.
        String x = "park";
        String y = "home";

        // Due to String interning in Java, this choice of assignments
        // will trigger the first and third if-statements.
        // String x = "park";
        // String y = "park";


        // We avoid interning by explicitly creating a new String
        // object on the heap. In this assignment scheme, the second
        // and third if-statements will have a true condition.
        // String x = new String("park");
        // String y = "park";

        if (x == y) {
            System.out.println("x and y are aliases.");
        }

        if (x != y) {
            System.out.println("x and y are not aliases");
        }

        if (x.equals(y)) {
            System.out.println("x and y have the same contents.");
            System.out.println("x: " + x);
            System.out.println("y: " + y);
        }
    }
}
