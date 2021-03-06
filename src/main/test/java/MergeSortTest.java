import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class MergeSortTest {

   private static File file = new File("testFile.txt");
   private static List<String> expectedList;

    /**
     * after MergeSortTest launch program inserts data into file
     * @throws IOException
     */
    @BeforeClass
    public static void createFile() throws IOException {
        Writer writer = new FileWriter(file);
        writer.append("book" + "\n");
        writer.append("kitchen" + "\n");
        writer.append("glass" + "\n");
        writer.append("car");
        writer.close();
    }

    /**
     * after MergeSortTest launch program inserts data into expectedList
     */
    @BeforeClass
    public static void createList(){
      expectedList = Arrays.asList("book", "kitchen", "glass", "car");
    }

    /**
     * Test if  MergerSort.fileToList(File file) method works correct
     * @throws IOException
     */

    @Test
    public void fileToListTest() throws IOException {

        List<String> actualList = MergeSort.fileToList(file);
        Assert.assertThat(actualList,is(expectedList));

    }



    @Test
    public void divideAndSortListTest() {
    }

    @Test
    public void writeListToFile() {
    }

    @Test
    public void mergeList() {
    }
}