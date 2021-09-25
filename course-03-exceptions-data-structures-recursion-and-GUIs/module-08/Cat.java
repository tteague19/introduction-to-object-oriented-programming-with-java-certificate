// Since a Cat is also a Pet, this class must inherit from parent
// class Pet. This class is concrete.

// Variables:
// int miceCaught
//
// Constructors:
// Cat(String name, double health, int painLevel, int miceCaught)
// miceCaught
// If miceCaught passed in is less than 0, set miceCaught to 0
//
// Cat(String name, double health, int painLevel)
// Default miceCaught is 0
//
// Methods:
// getters for all instance fields, which should be camelCase with the
// variable name, e.g. a variable named hello should have a getter
// getHello()
//
// int treat():
// Should heal()
// Returns the time taken (in minutes) to treat the pet. Round all
// values up.
// if number of miceCaught is less than 4, the minutes for treatment
// is equal to (painLevel *2)/health
// if miceCaught is in between 4 and 7 inclusive the minutes for
// treatment equals painLevel/health
// if miceCaught is greater than 7, the minutes for treatment equals
// painLevel/(health*2)
//
// void speak():
// Calls parent method
// Prints “meow” number of times of miceCaught
// Eg: if miceCaught = 3
// Print “meow meow meow”
// ALL UPPERCASE if painLevel is greater than 5, not inclusive
//
// boolean equals(Object o):
// Uses the equals() method in Pet as part of the decision-making with
//  the additional condition of miceCaught being the same

public class Cat extends Pet {
    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);

        if (miceCaught < 0) {
            this.miceCaught = 0;
        }
        else {
            this.miceCaught = miceCaught;
        }
    }

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }

    public int getMiceCaught() {
        return this.miceCaught;
    }

    public int treat() {
        super.heal();

        if (this.miceCaught < 4) {
            return (int) Math.ceil((2 * this.getPainLevel()) / this.getHealth());
        }
        else if (this.miceCaught <= 7) {
            return (int) Math.ceil(this.getPainLevel() / this.getHealth());
        }
        else {
            return (int) Math.ceil(this.getPainLevel() / (2 * this.getHealth()));
        }
    }

    public void speak() {
        super.speak();

        String message = "";
        for (int i = 0; i < this.miceCaught; i++) {
            String meow = (this.getPainLevel() > 5) ? "meow" : "MEOW";
            message = message + meow;
            // We place a space between each word unless it is the
            // last word in the message.
            if (i != (this.getPainLevel() - 1)) {
                message = message + " ";
            }
        }

        System.out.print(message);
    }

    public boolean equals(Object o) {
        if (o instanceof Cat) {
            boolean sameMiceCaught = (this.miceCaught == ((Cat) o).getMiceCaught());
            return (super.equals(o) && sameMiceCaught);
        }

        return false;
    }
}
