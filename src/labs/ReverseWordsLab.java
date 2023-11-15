package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class ReverseWordsLab {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
        System.out.println("\t R  E  V  E  R  S  E    W  O  R  D  S    L  A  B");
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
    }

    public static void read(String inputLocation, List<String> list) throws FileNotFoundException{

        //Create a File Object
        File file  = new File(inputLocation);

        //Opens up a file input stream
        Scanner scanner  = new Scanner(file);

        //FIXME: create a list to store words in reverse from each line
        List<String> reverseList;

        //read in the data using input scanner
        while (scanner.hasNextLine()) {

            //TODO: read in next line and store as a string

            //TODO: get each word on each line using a delimiter and store in index location

            //TODO: store words in reverse

            //TODO: use string builder to print out lines with space


            //TODO: add each line in reverse to list as a string

            //TODO: clear the words on each line
        }

        scanner.close();
    }


    public static void write(String outputLocation, List<String> list) throws FileNotFoundException{
        //Opens up a file output stream
        PrintStream writer  = new PrintStream(outputLocation);

        // TODO: write out lines using  Print Stream -> write

        //close output stream
        writer.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        String inputLocation    = "." + File.separator + "data"
                                      + File.separator + "words.txt";

        String outputLocation   = "." + File.separator + "results"
                                      + File.separator + "reverse_words.txt";

        // TODO: update program to use an Array List

        // TODO: process items in file (REVERSALS, can be done either in main or in read)

    }

}
