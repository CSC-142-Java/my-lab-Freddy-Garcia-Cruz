package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static spacex.Controller.intro;

public class ReverseWordsLab {

    // Existing code...

    public static void read(String inputLocation, List<String> list) throws FileNotFoundException {
        File file = new File(inputLocation);
        Scanner scanner = new Scanner(file);
        List<String> reverseList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                sb.append(words[i]);
                if (i > 0) sb.append(" ");
            }
            reverseList.add(sb.toString());
        }

        list.addAll(reverseList);
        scanner.close();
    }

    public static void write(String outputLocation, List<String> list) throws FileNotFoundException {
        PrintStream writer = new PrintStream(outputLocation);
        for (String line : list) {
            writer.println(line);
        }
        writer.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String inputLocation = "." + File.separator + "data" + File.separator + "words.txt";
        String outputLocation = "." + File.separator + "results" + File.separator + "reverse_words.txt";

        List<String> list = new ArrayList<>();

        intro();
        read(inputLocation, list);
        write(outputLocation, list);
    }
}