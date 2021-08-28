public class ArraySearch {
    public static void main(String[] args) {
        String[] concepts = {"abstraction", "polymorphism",
                        "inheritance", "incapsulation"};
        String result = searchStringArray("polymorphism", concepts);
        System.out.println(result);

        result = searchStringArray("inheritance", concepts);
        System.out.println(result);
    }

    public static String searchArray(String target, String[] array) {

        String result = "not found";
        for (String element : array) {
            if (element.equals(target)) {
                result = "found";
                break;
            }
        }
        return result;
    }

    public static String searchArray(int target, int[] array) {

        String result = "not found";
        for (int element : array) {
            if (element == target) {
                result = "found";
                break;
            }
        }
        return result;
    }
}
