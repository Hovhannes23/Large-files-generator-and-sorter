import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {

    public static List<String> fileToList (File inputFile) throws FileNotFoundException { // метод считывает строки из файла, записывает их в List и возвращает его

        List<String> lines = new ArrayList<>();
        Scanner inputFileScanner= new Scanner(inputFile);

        while (inputFileScanner.hasNextLine()){
           lines.add(inputFileScanner.nextLine());
        }

        return lines;
    }

    public static List<String> divideList(List<String> inputList){

        if (inputList==null)
            return null;

        if(inputList.size()<2)
            return inputList;

        List<String> listL = new ArrayList<>();
        List<String> listR = new ArrayList<>();

        System.arraycopy(inputList,0,listL,0,inputList.size()/2);
        System.arraycopy(inputList,inputList.size()/2,listR,0,inputList.size()-inputList.size()/2);

        listL = divideList(listL);
        listR = divideList(listR);

       return sortList(listL,listR);

    }


    public static List<String> sortList(List<String> listL, List<String>listR){  // метод 2 сортированных списка слияет и сортирует

        int indexL=0;
        int indexR=0;

        List<String> sortedList = new ArrayList<>();

        for(int i=0;i<(listL.size()+listR.size());i++) {

             if (indexL==listL.size()) {
                 sortedList.add(listR.get(indexR));
                 indexR++;
             }

             else if (indexR==listR.size()) {
                 sortedList.add(listL.get(indexL));
                 indexL++;
             }
             else if ((listL.get(indexL).compareTo(listR.get(indexR)) <= 0)) {
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


