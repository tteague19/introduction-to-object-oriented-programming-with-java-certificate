import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileText {
    public static void main(String[] args) {
        String inputFileName = args[0];
        String word = args[1];
        String outputFileName = args[2];

        File fileIn = new File(inputFileName);
        File fileOut = new File(outputFileName);

        Scanner fileScan = null;
        PrintWriter filePrint = null;

        try {
            fileScan = new Scanner(fileIn);
            filePrint = new PrintWriter(fileOut);

            int lineCount = 0;
            filePrint.printf("Lines in %s containing %s\n",
                                args[0], args[1]);

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                if (line.contains(word)) {
                    filePrint.println(lineCount + ": " + line);
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
            if (filePrint != null) {
                filePrint.close();
            }
        }
    }
}
