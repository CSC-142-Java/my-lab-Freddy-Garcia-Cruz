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
        List<String> reverseList = new ArrayList<>(); // Fix

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // Read next line
            String[] words = line.split(" "); // Split into words
            StringBuilder sb = new StringBuilder(); // To build reversed line
            for (int i = words.length - 1; i >= 0; i--) { // Reverse words
                sb.append(words[i]);
                if (i > 0) sb.append(" "); // Add space between words
            }
            reverseList.add(sb.toString()); // Add reversed line to list
        }

        list.addAll(reverseList); // Add all to the provided list for further use
        scanner.close();
    }

    public static void write(String outputLocation, List<String> list) throws FileNotFoundException {
        PrintStream writer = new PrintStream(outputLocation);
        for (String line : list) {
            writer.println(line); // Write out lines
        }
        writer.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String inputLocation = "." + File.separator + "data" + File.separator + "words.txt";
        String outputLocation = "." + File.separator + "results" + File.separator + "reverse_words.txt";

        List<String> list = new ArrayList<>(); // Use Array List

        intro();
        read(inputLocation, list);
        write(outputLocation, list);
    }
}