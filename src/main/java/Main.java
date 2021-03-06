
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
//
//        File file = new File("src/main/resources/Text");
//        Scanner scanner = new Scanner(file);
//        List<String> words = new ArrayList<>();
//        while (scanner.hasNext()) {
//            words.add(scanner.next());
//        }
//
//        Collections.sort(words);
//
//        System.out.println(words);
//
//        Writer out=new BufferedWriter(new FileWriter("sortedText.txt"));
//
//        for (String s : words) {
//                out.append(s);
//                out.append("\n");
//            }
//        out.close();
//

        List<String> listL = List.of("а","ж","х","я");
        List<String> listR = List.of("а","в","г","я");


        System.out.println(MergeSort.divideList(List.of("а","э","т","б","д","в","х","я","а","з","ы","р","д","ч","ъ","я")));


    }
    }



