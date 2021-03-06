import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GeneratorTest {

    /**
     * Test checks if number of lines is right and  length of any line is less than max length
     * @throws FileNotFoundException
     */
    @Test
    public void generateFileTest() throws FileNotFoundException {

       File file = Generator.generateFile(30,10);
        Scanner scanner = new Scanner(file);

        int countOfLines = 0;
        int maxLengthOfLine = 0;

        while (scanner.hasNextLine()) {
           String line = scanner.nextLine();
            countOfLines++; // count number of lines
           if (line.length()>maxLengthOfLine)
               maxLengthOfLine = line.length(); // set current max length of lines
        }

        Assert.assertEquals(30,countOfLines);
        Assert.assertTrue(maxLengthOfLine<11);
        System.out.println(maxLengthOfLine);

    }
}