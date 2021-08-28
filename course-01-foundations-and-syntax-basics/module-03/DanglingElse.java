public class DanglingElse {
    public static void main(String[] args) {
        int num = 9;
        if (num > 0)
        if (num < 10)
        // This statement will run, since Java matches a dangling
        // else statement to its closest unmatched if branch.
        System.out.println("aaa");
        else
        System.out.println("bbb");
    }
}
