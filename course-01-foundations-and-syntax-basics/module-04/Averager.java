public class Averager {
    public static void main(String[] args) {
        double[] weekHighs = {80, 70, 75, 69, 72, 74, 90};
        double highsSum = 0;
        for (double dayHigh : weekHighs) {
            highsSum = highsSum + dayHigh;
        }
        double averageHighs = highsSum / weekHighs.length;
        System.out.println("Average is: " + averageHighs);
    }
}
