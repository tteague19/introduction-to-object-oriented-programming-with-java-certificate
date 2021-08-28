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

        // Sub-Task 3
        // Lastly, let’s work with some URLs.  Declare a new String
        // and give it the value of some web address, in the form
        // www.name.tld, such as www.gatech.edu or
        // www.stackoverflow.com. Print out this address.
        String urlString = "www.80000hours.org";
        System.out.println(urlString);

        // Sub-Task 4
        // This last operation could be a little tricky. Create a
        // substring of the variable that’s just the “name” section,
        // and concatenate the integer “1331” to the end. For example,
        // www.gatech.edu would become gatech1331. Print out this
        // final result. Note: the String class has a .length() method
        // which you’ll likely find useful here but is not necessary.
        int prefixLen = "www.".length();
        int suffixLen = ".org".length();
        int urlLen = urlString.length();
        int endIndex = urlLen - suffixLen;
        String subString = urlString.substring(prefixLen, endIndex);
        String concatString = subString.concat("1331");
        System.out.println(concatString);
    }
}
