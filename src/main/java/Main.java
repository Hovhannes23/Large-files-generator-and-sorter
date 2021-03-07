import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = Generator.generateFile(300_000, 10);  // generate file with 300_000 lines and max length of lines is 10 (generatedFile.txt)

        List<String> unsortedList = MergeSort.fileToList(file); // each line of this file we write to list as its element

        MergeSort.divideAndSortList(unsortedList);  // then divide huge list into smaller ones, sort each of then
                                                  // and then merge and sort then into bigger list. This list we write to sortedFile.txt
    }
}



