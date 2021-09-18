public interface Groomable {
    public void groom();

    default void pay() {
        System.out.println("Cha-Ching!");
    }
}