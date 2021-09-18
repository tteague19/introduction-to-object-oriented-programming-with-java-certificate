public class Fly {
    // Defines Fly objects that exist within a pond

    // The fly must have these variables
    // mass - the mass of the Fly in grams (it must allow decimal values)
    // speed - how quickly this Fly can maneuver through the air while
    //      flying, represented as a double
    private double mass;
    private double speed;
    public static final double DEFAULT_MASS = 5D;
    public static final double DEFAULT_SPEED = 10D;

    // You must use constructor chaining in at least two of your
    // constructors. Duplicate code cannot exist in multiple constructors.
    // A constructor that takes in mass and speed of a Fly.
    // A constructor that takes only mass.
    //      By default, the Fly will have 10 speed
    // A constructor that takes in no parameters.
    //      By default, the Fly will have 5 mass and 10 speed.
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    public Fly() {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    // Do not create any other methods than those specified. Any extra
    // methods will result in point deductions. All methods must have
    // the proper visibility to be used where it is specified they are
    // used.
    //
    // Setters and getters (using appropriately named methods) for all
    // variables in Fly.java.
    //
    // toString - takes in no parameters and returns a String describing
    // the Fly as follows:
    //      If mass is 0: "I'm dead, but I used to be a fly with a
    //      speed of [speed]"
    //      Otherwise: "I'm a speedy fly with [speed] speed and [mass] mass."
    //
    // grow - takes in an integer parameter representing the added mass.
    // Then, it increase the mass of the Fly by the given number of
    // mass. As mass increases, speed changes as follows:
    //      If mass is less than 20: increase speed by for every mass
    //      the fly grows until it reaches 20 mass.
    //      If the mass is 20 or more: decrease speed by 0.5 for each
    //      mass unit added over 20.
    //
    // isDead - if mass is zero, return true. Otherwise, return false.
    public double getMass() {
        return this.mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String toString() {
        if (this.mass == 0) {
            String formatString = "I'm dead, but I used to be a fly with"
                                    + " a speed of %.2f.";
            return String.format(formatString, this.speed);
        }
        else {
            String formatString = "I'm a speedy fly with"
                                    + " %.2f speed and %.2f mass.";
            return String.format(formatString, this.speed, this.mass);
        }
    }

    public void grow(int addedMass) {

        for (int index = 1; index <= addedMass; index++) {
            this.mass = this.mass + 1;

            if (this.mass <= 20.0) {
                this.speed = this.speed + 1;
            }
            else {
                this.speed = this.speed - 0.5;
            }
        }
    }

    public boolean isDead() {
        return this.mass == 0.0;
    }
}
