import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = Generator.generateFile(30, 10);
        List<String> unsortedList = MergeSort.fileToList(file);
        MergeSort.divideAndSortList(unsortedList);
    }
}



