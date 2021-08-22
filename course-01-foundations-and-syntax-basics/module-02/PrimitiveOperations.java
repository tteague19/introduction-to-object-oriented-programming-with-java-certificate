public class PrimitiveOperations {
    public static void main(String[] args) {
        // First, declare and initialize two variables, an integer
        // type (byte, short, int, or long) and a floating point value
        // (float or double). The names and values can be whatever you
        // like, for this step and all others. Make sure that the
        // numbers you choose can be stored within the respective
        // primitive type you choose. Print each of these values out
        // on their own line using System.out.println().
        int intVar;
        double doubleVar;
        intVar = 19;
        doubleVar = 1729.56;
        System.out.println(intVar);
        System.out.println(doubleVar);

        // Multiply these variables together, and assign the outcome
        // to a new variable, ensuring that no data is lost. For
        // example, if I multiply 5 and 3.5, the answer should be
        // 17.5. Print out this new value.
        double product = intVar * doubleVar;
        System.out.println(product);

        // Use casting to convert the integer from the first step to a
        // floating point value and store that in another new
        // variable. Print out the value.
        float convertedIntToFloat = (float) intVar;
        System.out.println(convertedIntToFloat);

        // Use casting to convert the floating point value from the
        // first step to an integer type and store that in a new
        // variable. Print out the value.
        int convertedDoubleToInt = (int) doubleVar;
        System.out.println(convertedDoubleToInt);
    }
}
