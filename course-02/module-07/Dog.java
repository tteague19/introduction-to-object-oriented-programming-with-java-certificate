public class Dog extends Canine {

    protected String name;

    public Dog(String name, double size) {
        super(size);
        this.name = name;
    }

    public void fetch() {
        System.out.println("Run");
        System.out.println("Clinch");
        System.out.println("Return");
    }

    public void groom() {};

    public boolean equals(Object o) {
        if (!(o instanceof Dog)) {
            return false;
        }

        Dog dog = (Dog) o;
        return ((dog.size == this.size) && (dog.name.equals(this.name)));
    }

    public static void main(String[] args) {
        Dog spot = new Dog("Spot", 9.6);
        spot.bark();

        Dog spotTwin = new Dog("Spot", 9.6);
        System.out.println(spot.equals(spotTwin));

        Dog spotBig = new Dog("Spot", 15.0);
        System.out.println(spot.equals(spotBig));
    }
}
