public class Wolf extends Canine implements Comparable {

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

    public void groom() {
        System.out.println("lick");
    };

    public int compareTo(Wolf anotherWolf) {
        return - (this.rank - anotherWolf.rank);
    }

    public static void main(String[] args) {
        Wolf alpha = new Wolf(1, 17.1);
        Wolf puppy = new Wolf(10, 3.0);
        System.out.println(alpha.compareTo(puppy));
    }
}
