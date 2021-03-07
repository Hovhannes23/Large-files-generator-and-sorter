import java.io.*;
import java.util.Random;
import java.util.stream.Collectors;


public class Generator {

    /**
     * Method generates file with random content
     * @param countOfLines  - count of lines in generatedFile
     * @param maxLengthOfLine  - max length of line
     * @return  generated file
     */
    public static File generateFile(int countOfLines, int maxLengthOfLine) {
        File generatedFile = new File("generatedFile.txt"); // create file to which we`ll write generated text

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray(); // create char[] of letters

       try(Writer out=new BufferedWriter(new FileWriter(generatedFile))) { // create writer which will write text to our generated file

           for (int i = 0; i < countOfLines; i++) {   // in this loop we randomly choose letters and concat them to StringBuilder.
                                                      // Count of letters in one line is from 1 to maxLengthOfLine.
               StringBuilder res =
                        new StringBuilder(new Random().ints(new Random().nextInt(maxLengthOfLine) + 1, 0, chars.length)
                                // randomly choose ints from 0 to 51. Work via StringBuilder in order to use memory efficiently
                       .mapToObj(c -> String.valueOf(chars[c])) // from char[] we get char by ints and convert its to String
                       .collect(Collectors.joining())); // then concat them to String
               out.append(res); // write StringBuilder to generatedFile
               out.append("\n");
           }
       }
        catch (IOException e){
           e.printStackTrace();
        }

        return generatedFile;

    }
}
