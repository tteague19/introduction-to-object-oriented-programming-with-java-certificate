import java.util.Random;

public class Die {

    public static final int SIDES = 6;
    private int faceValue;
    private Random rand;

    public Die() {
        this.faceValue = 1;
        this.rand = new Random();
    }

    public int roll() {
        faceValue = this.rand.nextInt(SIDES) + 1;
        return faceValue;
    }

    public int getFaceValue() {
        return this.faceValue;
    }

    public String toString() {
        return "Die with face value: " + faceValue;
    }

    public static void main(String[] args) {
        Die die1 = new Die();

        System.out.println(die1);
        System.out.println(die1.roll());
        System.out.println(die1.roll());
    }
}
