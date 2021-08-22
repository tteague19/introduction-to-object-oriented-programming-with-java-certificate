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

        // Shifting focus, declare a char variable, and assign an
        // uppercase letter to it. Print out this value.
        char charVar = 'T';
        System.out.println(charVar);

        // Using a numerical operation, change the letter to the same
        // letter, but in lowercase. Use a numerical operation - do
        // not reassign the variable. You may want to review a table
        // of ASCII values as you’re working on this section. Print
        // out the new char value. Hint: you’ll likely have to use
        // casting to get this to work.

        // Uppercase letters are listed in alphabetical order starting
        // with the decimal code of 65. There are 26 letters in the
        // English alphabet and six markings listed in ASCII after the
        // uppercase letters. Lowercase letters begin at the decimal
        // code 97. Thus, the code for a lowercase English letter
        // character in ASCII is 32 values higher than the code for
        // its uppercase counterpart.
        int upperToLowerShift = 32;

        // We cast the char variable to an integer to convert it to
        // its character code. For 'T', this is 84. We then add the
        // shift to obtain an integer value of 116. 116 is the
        // character code for 't', and, finally, we cast 116 as a char
        // to obtain a lowercase 't' for charVar.
        charVar = (char) ((int) charVar + upperToLowerShift);
        System.out.println(charVar);
    }
}
