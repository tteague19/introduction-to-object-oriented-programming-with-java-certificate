public class SomeOtherProgram {
    public static void main(String[] args) {
        String[] lullabies = {"Wheels on the Bus",
                        "Twinkle, Twinkle Little Star",
                        "Itsy Bitsy Spider",
                        "Swing Low Sweet Chariot",
                        "Amazing Grace"};

        System.out.println(ArraySearch.searchStringArray("Amazing Grace", lullabies));
        System.out.println(ArraySearch.searchStringArray("Humpty Dumpty", lullabies));
    }
}
