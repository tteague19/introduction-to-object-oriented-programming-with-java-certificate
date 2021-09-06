public class Insect {

    // Instance variables
    private double weight;
    private int x;
    private int y;

    public Insect(double initWeight, int initX, int initY) {
        weight = initWeight;
        x = initX;
        y = initY;
    }

    // Test method
    public static void main(String[] args) {
        // Insect buzz1 = new Insect();
        // Insect buzz2 = new Insect();
        Insect bug1 = new Insect(10, 100, 90);
        Insect bug2 = new Insect(4, -300, 400);
    }
}
