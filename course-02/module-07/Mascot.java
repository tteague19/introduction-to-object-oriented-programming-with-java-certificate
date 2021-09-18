public abstract class Mascot {

    public static double MAX_CELEBRATION_SEC = 30;
    public static int MAX_VOLUME = 100;
    public static int MAX_SPEED = 10;

    private int speed;
    private int volume;
    private String name;

    public abstract void celebrate();
    public abstract void whine();
    public abstract void chant();
    public abstract void run();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVolume(int volume) {
        if (volume <= MAX_VOLUME) {
            this.volume = volume;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setSpeed(int speed) {
        if (speed <= MAX_SPEED) {
            this.speed = speed;
        }
    }

    public int getSpeed() {
        return speed;
    }
}