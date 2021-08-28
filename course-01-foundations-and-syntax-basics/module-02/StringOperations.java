public class StringOperations {
    public static void main(String[] args) {
        // Sub-Task 1
        // Create a new String object and assign it your name.
        // Print it out.
        String myName = "Thomas";
        System.out.println(myName);

        // Sub-Task 2
        // Pick the first letter in your name, and replace it with
        // ‘A’. Then, replace the last letter in your name with ‘Z’.
        // Print out the result. Recall that, in Java, strings are
        // immutable, meaning you cannot change a String in-place. Do
        // NOT just hard-code a new String with the first and last
        // letters changed

        // Fortunately, my name does not contain any repeated letters.
        // If it did, I would need to use the substring method.
        String myNameModified = myName.replace('T', 'A');
        myNameModified = myNameModified.replace('s', 'Z');
        System.out.println(myNameModified);
    }
}
