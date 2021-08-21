/*
A program that illustrates the immutability of Strings
*/
public class StringTwist {
    public static void main(String[] args) {
        String funnyStr = "Computer!Science,!long!walks!on!the!beach";

        // These operations return a new string, but we do not assign
        // the string to a variable. Thus, they become unaccessible
        // and are destroyed during garbage collection.
        funnyStr.replace("!", " ");
        funnyStr.replace("the beach", "");
        funnyStr.replace(", long", "");
        funnyStr.replace("wal", "roc");
        funnyStr.toUpperCase();

        // When we display the variable, we see it has not changed
        // from the original assignment.
        System.out.println(funnyStr);

        // If we assign each return to a variable and operate on each
        // new variable in the correct sequence, we can progressively
        // convert the original message into "COMPUTER SCIENCE ROCKS!"
        String funnyStr1 = funnyStr.replace("!", " ");
        String funnyStr2 = funnyStr1.replace("the beach", "");
        String funnyStr3 = funnyStr2.replace(", long", "");
        String funnyStr4 = funnyStr3.replace("wal", "roc");
        String funnyStr5 = funnyStr4.toUpperCase();

        System.out.println(funnyStr1);
        System.out.println(funnyStr2);
        System.out.println(funnyStr3);
        System.out.println(funnyStr4);
        System.out.println(funnyStr5);
    }
}