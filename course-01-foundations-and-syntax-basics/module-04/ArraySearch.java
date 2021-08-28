public class ArraySearch {
    public static void main(String[] args) {
        String[] concepts = {"abstraction", "polymorphism",
                        "inheritance", "incapsulation"};
        String result = searchStringArray("polymorphism", concepts);
        System.out.println(result);

        result = searchStringArray("inheritance", concepts);
        System.out.println(result);
    }

    public static String searchStringArray(String target, String[] array) {

        String result = "not found";
        for (String element : array) {
            if (element.equals(target)) {
                result = "found";
                break;
            }
        }
        return result;
    }
}
