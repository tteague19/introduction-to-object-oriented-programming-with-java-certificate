import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileText {
    public static void main(String[] args) {
        String inputFileName = args[0];
        String word = args[1];

        File fileIn = new File(inputFileName);

        Scanner fileScan = null;

        try {
            fileScan = new Scanner(fileIn);
            int lineCount = 0;
            System.out.printf("Lines in %s containing %s\n",
                                args[0], args[1]);

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                if (line.contains(word)) {
                    System.out.println(lineCount + ": " + line);
                }
                lineCount++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }
    }
}
