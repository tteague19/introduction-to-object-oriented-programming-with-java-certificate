public class Averager {
    public static void main(String[] args) {
        double[] weekHighs = {80, 70, 75, 69, 72, 74, 90};
        double highsSum = 0;
        for (int index = 0; index < weekHighs.length; index++) {
            highsSum = highsSum + weekHighs[index];
        }
        double averageHighs = highsSum / weekHighs.length;
        System.out.println("Average is: " + averageHighs);
    }
}
