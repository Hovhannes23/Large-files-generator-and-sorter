import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {

/**
 * method reads lines from file, write them to list and returns that list
 * @param inputFile - from this file we read lines
 * @return lines
 */
    public static List<String> fileToList (File inputFile) throws IOException {

        List<String> lines = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;

        while(!((line=reader.readLine())==null)) {
            lines.add(line);
        }
        reader.close();

        return lines;
    }


    /**
     * @param inputList - method divides this list recursively till it divides.
     *                  And then merge and sort lists
     * @return sortedList
     * Method also write sorted list to file
     */
    public static List<String> divideAndSortList(List<String> inputList){

        if (inputList==null)
            return null;

        if(inputList.size()<2)
            return inputList;

        List<String> listL;
        List<String> listR;

        listL = inputList.subList(0,inputList.size()/2);
        listR = inputList.subList(inputList.size()/2,inputList.size());

        listL = divideAndSortList(listL);
        listR = divideAndSortList(listR);

        List<String> sortedList = mergeList(listL,listR);

        writeListToFile(sortedList);

       return sortedList;

    }


    /**
     * @param list - method writes to file content of this list
     */
    public static void writeListToFile(List<String> list){

        try (Writer out = new BufferedWriter(new FileWriter("sortedFile.txt"))) {
            for (String s : list) {
                out.append(s);
                out.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param listL  - left sorted list
     * @param listR - right sorted list
     * @return sortedList
     * Method merge and sort two sorted lists
     */

    public static List<String> mergeList(List<String> listL, List<String>listR){

        int indexL=0; // current index of listL
        int indexR=0; // current index of listR

        List<String> sortedList = new ArrayList<>();

        for(int i=0;i<(listL.size()+listR.size());i++) {

             if (indexL==listL.size()) {    // if there is no elements in listL, we add to sortedList elements of listR
                 sortedList.add(listR.get(indexR));
                 indexR++;
             }

             else if (indexR==listR.size()) {  // if there is no elements in listR, we add to sortedList elements of listL
                 sortedList.add(listL.get(indexL));
                 indexL++;
             }
             else if ((listL.get(indexL).compareTo(listR.get(indexR)) <= 0)) {  // compare two elements from listL and listR, and
                                                                               //  write smaller element to sortedList.
                sortedList.add(listL.get(indexL));
                indexL++;
            }
             else if ((listL.get(indexL).compareTo(listR.get(indexR)) > 0)) {
                sortedList.add(listR.get(indexR));
                indexR++;
            }
        }

        return sortedList;

    }


}


