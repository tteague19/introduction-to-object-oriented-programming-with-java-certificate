public class SomeOtherProgram {
    public static void main(String[] args) {
        String[] lullabies = {"Wheels on the Bus",
                        "Twinkle, Twinkle Little Star",
                        "Itsy Bitsy Spider",
                        "Swing Low Sweet Chariot",
                        "Amazing Grace"};

        System.out.println(ArraySearch.searchArray("Amazing Grace", lullabies));
        System.out.println(ArraySearch.searchArray("Humpty Dumpty", lullabies));

        int[] weekHighs = {80, 70, 75, 69, 72, 74, 90};
        System.out.println(ArraySearch.searchArray(90, weekHighs));
    }
}
