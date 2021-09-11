public class Pond {
    public static void main(String[] args) {
        // Main method must act as such:
        // Must create at least 4 Frog objects:
        // Frog with name Peepo.
        // Frog with name Pepe, age 10 months, and tongueSpeed of 15.
        // Frog with name Peepaw, age 4.6 years, and tongueSpeed of 5.
        // Frog of your liking :)
        // Must create at least 3 Fly objects:
        // Fly with 1 mass and speed of 3.
        // Fly with 6 mass.
        // Fly of your liking :)
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5D);
        // Kermit the Frog debuted in 1955. His tongue speed is unknown :)
        Frog kermit = new Frog("Kermit", 792, 19D);

        Fly william = new Fly(1D, 3D);
        Fly seth = new Fly(6D);
        Fly jeff = new Fly(19D, 86D);

        // Perform the following operations in this order:
        // Set the species of any Frog to “1331 Frogs”
        Frog.setSpecies("1331 Frogs");

        // Print out on a new line the description of the Frog named
        // Peepo given by the toString method.
        System.out.println(peepo);

        // Have the Frog named Peepo attempt to eat the Fly with a mass of 6.
        peepo.eat(seth);

        // Print out on a new line the description of the Fly with a
        // mass of 6 given by the toString method.
        System.out.println(seth);

        // Have the Frog named Peepo grow by 8 months.
        peepo.grow(8);

        // Have the Frog named Peepo attempt to eat the Fly with a mass of 6.
        peepo.eat(seth);

        // Print out on a new line the description of the Fly with a
        // mass of 6 given by the toString method.
        System.out.println(seth);

        // Print out on a new line the description of the Frog named
        // Peepo given by the toString method.
        System.out.println(peepo);

        // Print out on a new line the description of your own Frog
        // given by the toString method.
        System.out.println(kermit);

        // Have the Frog named Peepaw grow by 4 months.
        peepaw.grow(4);

        // Print out on a new line the description of the Frog named
        // Peepaw given by the toString method.
        System.out.println(peepaw);

        // Print out on a new line the description of the Frog named
        // Pepe given by the toString method.
        System.out.println(pepe);
    }
}
