public class Frog {
    // Defines Frog objects that exist within a pond

    // The Frog class must have thse variables:
    //
    // name - the name of this Frog, which can be made of any
    //      combination of characters
    //
    // age - the age of the Frog as an integer number of months
    //
    // tongueSpeed - how quickly this Frog’s tongue can shoot out of
    //      its mouth, represented as a double
    //
    // isFroglet - a value that represents if this Frog is young
    //      enough to be a froglet (the stage between tadpole and
    //      adult frog), which must only have two possible
    //      values - true or false. A Frog is a froglet if it is more
    //      than 1 month old but fewer than 7 months old. Whenever age
    //      is changed, this variable must be updated accordingly.
    //
    // species - the name of the species of this Frog, which must be
    //      the same for all instances of Frog (Hint: there is a keyword
    //      you can use to accomplish this). By default, its value must
    //      be “Rare Pepe”.
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";
    public static final int DEFAULT_AGE = 5;
    public static final double DEFAULT_TONGUE_SPEED = 5D;

    // You must use constructor chaining in at least two of your
    // constructors. Duplicate code cannot exist in multiple constructors.
    //
    // A constructor that takes in name, age, and tongueSpeed and sets
    // all variables appropriately.
    //
    // A constructor that takes in name, ageInYears representing the
    //      age of the Frog in years as a double, and tongueSpeed and
    //      sets all variables appropriately.
    //      When converting ageInYears to age (in an integer number of
    //      months), round down to the nearest month without using any
    //      method calls (Hint: Java can automatically do this for you
    //      with casting).
    //
    // A constructor that takes in just a name.
    //      By default, a Frog is 5 months old and has a tongueSpeed
    //      of 5.
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;

        if ((this.age > 1) && (this.age < 7)) {
            this.isFroglet = true;
        }
        else {
            this.isFroglet = false;
        }
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, (int) (ageInYears * 12), tongueSpeed);
    }

    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TONGUE_SPEED);
    }

    // You must use method overloading at least once. Do not create
    // any other methods than those specified. Any extra methods will
    // result in point deductions. All methods must have the proper
    // visibility to be used where it is specified they are used.
    //
    // grow - takes in a whole number parameter representing the
    // number of months. Then it ages the Frog by the given number of
    // months and increases tongueSpeed by 1 for every month the Frog
    // grows until it becomes 12 months old.
    // If the Frog is 30 months old or more, then decrease tongueSpeed
    // by 1 for every month that it ages beyond 30 months.
    // You must not decrease tongueSpeed to less than 5.
    // Remember to update isFroglet accordingly
    //
    // grow - takes in no parameters and ages the Frog by one month
    // and updates tongueSpeed accordingly as for the other grow method
    //
    // eat – takes in a parameter of a Fly to attempt to catch and eat.
    // Check if Fly is dead, and if it is dead then terminate the method.
    // The Fly is caught if tongueSpeed is greater than the speed of
    // the Fly.
    // If the Fly is caught and the mass is at least 0.5 times the age
    // of the Frog, the Frog ages by one month using the method grow.
    // If the Fly is caught, the mass of the Fly must be set to 0.
    // If the Fly is NOT caught, the mass of the Fly must be increased
    // by 1 while updating the speed of the Fly using only one Fly method.
    //
    // toString - returns a String describing the Frog as follows:
    // (Note: replace the values in brackets [] with the actual value.
    // Do not include the double quotes “” or the square brackets []
    // in the output. Specify all decimal values to 2 decimal points.)
    // If frog is a froglet, returns “My name is [name] and I’m a rare
    // froglet! I’m [age] months old and my tongue has a speed of
    // [tongueSpeed].”
    // Otherwise, returns “My name is [name] and I’m a rare frog. I’m
    // [age] months old and my tongue has a speed of [tongueSpeed].”
    //
    // Setter and getter for species which must change the value for
    // all instances of the class. Points will be deducted if you
    // include an unnecessary or inappropriate setter/getter.
    public void grow(int numMonths) {

        for (int index = 1; index <= numMonths; index++) {
            this.age = this.age + 1;

            if (this.age <= 12) {
                this.tongueSpeed = this.tongueSpeed + 1;
            }
            else if (this.age > 30) {
                this.tongueSpeed = this.tongueSpeed - 1;
            }
        }

        if (this.tongueSpeed < 5D) {
            this.tongueSpeed = 5D;
        }

        // Update isFroglet
        if ((this.age > 1) && (this.age < 7)) {
            this.isFroglet = true;
        }
        else {
            this.isFroglet = false;
        }
    }

    public void grow() {
        this.age = this.age + 1;

        if (this.age <= 12) {
            this.tongueSpeed = this.tongueSpeed + 1;
        }
        else if (this.age >= 30) {
            this.tongueSpeed = this.tongueSpeed - 1;
        }

        // Update isFroglet
        if ((this.age > 1) && (this.age < 7)) {
            this.isFroglet = true;
        }
        else {
            this.isFroglet = false;
        }
    }

    public void eat(Fly fly) {
        if (fly.isDead()) {
            return;
        }

        boolean isCaught = (this.tongueSpeed > fly.getSpeed());
        if (isCaught && (fly.getMass() >= 0.5 * this.age)) {
            this.grow(1);
        }

        if (isCaught) {
            fly.setMass(0.0);
        }

        if (!isCaught) {
            fly.grow(1);
        }
    }

    public String toString() {
        if (this.isFroglet) {
            String outStr = "My name is %s and I'm a rare froglet! I'm %d"
                            + " months old and my tongue has a speed of %.2f.";
            return String.format(outStr, this.name, this.age, this.tongueSpeed);
        }
        else {
            String outStr = "My name is %s and I'm a rare frog. I'm %d months "
                            + "old and my tongue has a speed of %.2f.";
            return String.format(outStr, this.name, this.age, this.tongueSpeed);
        }
    }

    public static String getSpecies() {
        return species;
    }

    public static void setSpecies(String newSpecies) {
        species = newSpecies;
    }
}
