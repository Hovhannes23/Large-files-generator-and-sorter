import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileContentSorter {

    public static File sortContent(File file) {

        File sortedFile = new File("sortedFile.txt");

        List<String> words = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Collections.sort(words);

        try (Writer out = new BufferedWriter(new FileWriter(sortedFile));) {
            for (String s : words) {
                out.append(s);
                out.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sortedFile;
    }
}
