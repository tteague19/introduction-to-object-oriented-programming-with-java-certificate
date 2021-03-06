public class InsectClient {
    public static void main(String[] args) {
        System.out.println(Insect.produceRandomFact());
        Insect bug1 = new Insect(13, 31, 0);
        System.out.println(bug1);
        System.out.println(Insect.getPopulation());

        // This call will not change the value, since we disallow
        // negative coordinates.
        bug1.setX(-314);
        System.out.println(bug1.getX());

        // This call will change the value.
        bug1.setX(133);
        System.out.println(bug1.getX());

        Insect bug2 = new Insect(31);
        System.out.println(bug2);
        System.out.println(Insect.getPopulation());
    }
}
