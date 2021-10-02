import java.util.ArrayList;

public class StringArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("Humpty Dumpty");
        playlist.add("Swing Low Sweet Chariot");
        playlist.add("Itsy Bitsy Spider");
        playlist.add("Twinkle, Twinkle Little Star");
        playlist.add("Wheels on the Bus");
        System.out.println(playlist.toString());

        playlist.remove("Humpty Dumpty");
        System.out.println(playlist.toString());
        System.out.println(playlist.contains("Humpty Dumpty"));
        System.out.println(playlist.contains("Itsy Bitsy Spider"));

        // Note that this song is added to the bottom/end of the list.
        playlist.add("Humpty Dumpty");
        System.out.println(playlist.toString());
    }
}
