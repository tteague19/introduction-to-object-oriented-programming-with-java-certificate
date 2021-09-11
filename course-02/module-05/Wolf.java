import java.util.Arrays;

public class Wolf extends Canine implements Comparable<Wolf> {

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

    public String toString() {
        return  ("Rank " + this.rank + ", Size " + this.size);
    }

    public static void main(String[] args) {
        Wolf[] pack = {
            new Wolf(2, 17.1),
            new Wolf(10, 3),
            new Wolf(7, 9.2),
            new Wolf(8, 9.1),
            new Wolf(3, 17.81),
            new Wolf(1, 16.2),
            new Wolf(4, 16),
            new Wolf(5, 16),
            new Wolf(6, 10),
            new Wolf(9, 5),
        };
        System.out.println("Unsorted Pack: " + Arrays.toString(pack));
        Arrays.sort(pack);
        System.out.println("====================");
        System.out.println("Sorted Pack: " + Arrays.toString(pack));
    }
}
