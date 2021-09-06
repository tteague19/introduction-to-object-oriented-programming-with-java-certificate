public class Insect {

    // Instance variables
    private double weight;
    private int x;
    private int y;

    // Static constants and variables
    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;
    public static final double DIST_WEIGHT_LOSS_FACTOR = 0.0001;
    private static int population = 0;
    private static final String[] FACTS = {
        "The two main groups of insects are winged and wingless",
        "There are more than 1 million insect species",
        "Insects are cold-blooded",
        "Spiders are not considered insects"
    };

    public Insect(double weight) {
        this(weight, DEFAULT_X, DEFAULT_Y);
    }

    public Insect(double weight, int x, int y) {
        this.weight = weight;
        this.x = x;
        this.y = y;
        population++;
    }

    // Methods
    public double getWeight() {
        return this.weight;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        if (isLegalX(x)) {
            this.x = x;
        }
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        if (isLegalY(y)) {
            this.y = y;
        }
    }

    public static boolean isLegalX(int x) {
        return (x >= 0 ? true : false);
    }

    public static boolean isLegalY(int y) {
        return (y >= 0 ? true : false);
    }

    public static int getPopulation() {
        return population;
    }

    public void eat(double amount) {
        System.out.println("Nibble Nibble");
        this.weight = this.weight + amount;
    }

    public void move(int x, int y) {
        double distance = calculateDistance(this.x, this.y, x, y);
        if (distance > 0) {
            this.x = x;
            this.y = y;
            this.weight = this.weight - DIST_WEIGHT_LOSS_FACTOR * distance;
            System.out.printf("Moved %.2f units\n", distance);
        }
        else {
            System.out.println("Staying put");
        }
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));

    }

    public static String produceRandomFact() {
        int index = (int) (Math.random() * (FACTS.length - 1) + 1);
        return FACTS[index];
    }

    // Test method
    public static void main(String[] args) {
        // Insect buzz1 = new Insect();
        // Insect buzz2 = new Insect();
        System.out.println("Insect Population: " + population);
        Insect bug1 = new Insect(10, 100, 90);
        System.out.println("Insect Population: " + population);
        Insect bug2 = new Insect(4, -300, 400);
        System.out.println("Insect Population: " + population);

        bug1.move(1, 10);
        bug2.move(-300, 400);

        System.out.println(produceRandomFact());
    }
}
