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
   private static List<String> list;


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
      list = Arrays.asList("book", "kitchen", "glass", "car");
    }


    /**
     * Test if method MergerSort.fileToList(File file)  works correct
     * @throws IOException
     */
    @Test
    public void fileToListTest() throws IOException {

        List<String> actualList = MergeSort.fileToList(file);
        Assert.assertThat(actualList,is(list));
    }


    /**
     * test if method MergerSort.divideAndSortList(List<String>list)  works correct
     */
    @Test
    public void divideAndSortListTest() {

        List<String> actualList = MergeSort.divideAndSortList(list);
        List<String> expectedList = Arrays.asList("book","car","glass","kitchen");

        Assert.assertThat(actualList,is(expectedList));
    }


    /**
     * test if method MergeSort.mergeList works correct
     */
    @Test
    public void mergeListTest() {

        List<String>listL = Arrays.asList("book", "car", "glass", "kitchen");
        List<String>listR = Arrays.asList("home", "mountain", "notebook", "xerox", "zoo");

       List<String> actual = MergeSort.mergeList(listL,listR);
       List<String> expected = Arrays.asList("book", "car", "glass", "home", "kitchen", "mountain", "notebook", "xerox", "zoo");

       Assert.assertThat(actual,is(expected));

    }
}