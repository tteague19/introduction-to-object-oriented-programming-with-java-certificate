public class Wolf extends Canine {

    protected int rank;

    public Wolf(int rank, double size) {
        super(size);
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    public void bark() {
        // Wolves bark three times in our case.
        for (int i = 1; i <= 3; i++) {
            super.bark();
        }
    }

    public void groom() {};

    public static void main(String[] args) {
        Wolf alpha = new Wolf(1, 17.1);
        alpha.bark();
    }
}
