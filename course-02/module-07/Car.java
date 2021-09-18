public class Car implements Groomable {

    private String make;
    private String model;
    private int year;

    // This car is an electric vehicle.
    private int charge;
    private boolean powered;
    private int speed;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void start() {
        if (this.charge > 0) {
            System.out.println("ding");
            this.powered = true;
        }
    }

    public void groom() {
        if (speed == 0) {
            System.out.println("soap, rinse, wax, and "
                                + "little tree air freshener.");
        }
    }
}
