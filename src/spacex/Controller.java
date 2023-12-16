package spacex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    static String csvFileHeader;

    private static Mission parse(String line) throws IllegalArgumentException {
        String[]    str         = line.split(",");
        String[]    column      = new String[16];

        //copy data into larger array to fix issues with splitting
        for (int i = 0; i < str.length; i++)
            column[i] = str[i];


        // null values at the end set to empty
        if(str.length < column.length) {
            for (int i = str.length; i < column.length; i++) {
                column[i] = "";
            }
        }

        // Update the data with the values in the CSV file
        String      flightNumber    = column[0];
        Date        launchDate      = new Date(Integer.parseInt(column[1]), Month.valueOf(column[2]), Integer.parseInt(column[3]));
        Time        launchTime      = new Time(Integer.parseInt(column[4]), Integer.parseInt(column[5]));
        String      launchSite      = column[6];
        String      vehicleType     = column[7];
        double      mass            = Double.parseDouble(column[8]);
        Payload     payload         = new Payload(column[9], column[10], Double.parseDouble(column[11]), column[12]);
        Customer    customer        = new Customer(column[13], column[14], column[15]);
        String      missionOutcome  = column[16];
        String      failureReason   = column[17];
        String      landingType     = column[18];
        String      landingOutcome  = column[19];

        // Return Mission object using the builder pattern
        return new Mission.Builder()
                .flightNumber(flightNumber)
                .launchDate(launchDate)
                .launchTime(launchTime)
                .launchSite(launchSite)
                .vehicleType(vehicleType)
                .mass(mass)
                .payload(payload)
                .customer(customer)
                .missionOutcome(missionOutcome)
                .failureReason(failureReason)
                .landingType(landingType)
                .landingOutcome(landingOutcome)
                .build();
    }

    public static void read(List<Mission> list, String inputLocation) throws FileNotFoundException {
        File file    = new File(inputLocation);
        Scanner input = new Scanner(file);

        Mission missionData;

        // read in mission data and table header
        String csvFileHeader = input.nextLine();
        while (input.hasNextLine()) {
            missionData = parse(input.nextLine());
            list.add(missionData);
        }
        input.close();
    }

    public static void writeCustomersInOrder(List<Mission> list, String customer, String outputLocation)
            throws FileNotFoundException{
        String      csvLocation = outputLocation + File.separator + customer + ".csv";
        String      txtLocation = outputLocation + File.separator + customer + ".txt";
        File        csvFile     = new File(csvLocation);
        File        txtFile     = new File(txtLocation);
        PrintStream csvStream   = new PrintStream(csvFile);
        PrintStream txtStream   = new PrintStream(txtFile);

        Customer missionCustomer;
        Mission   mission;

        // get mission data with customer name.
        for (Mission m : list) {
            if (m.getCustomer().getName().equals(customer)) {
                csvStream.println(m);
                txtStream.println(m);
            }
        }
        csvStream.close();
        txtStream.close();
    }

    public static void writePayloadsByOrder(List<Mission> list, String outputLocation) throws FileNotFoundException {
        String      csvLocation = outputLocation + File.separator + "ordered_payload.csv";
        String      txtLocation = outputLocation + File.separator + "ordered_payload.txt";
        File        csvFile     = new File(csvLocation);
        File        txtFile     = new File(txtLocation);
        PrintStream csvStream   = new PrintStream(csvFile);
        PrintStream txtStream   = new PrintStream(txtFile);

        // sort payloads and order in a separate output file.
        list.stream()
                .map(Mission::getPayload)
                .forEach(csvStream::println);
        list.stream()
                .map(Mission::getPayload)
                .forEach(txtStream::println);

        csvStream.close();
        txtStream.close();
    }

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t  S P A C E   X    T E S T    P R O G R A M");
        System.out.println();
        System.out.println(" \t    S    T    A    R    T    I    N    G");
        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {

        String outputLocation  = "." + File.separator + "results";

        String inputLocation    = "." + File.separator + "data"
                + File.separator + "spacex_mission_data.csv";

        intro();

        List<Mission> list     = new ArrayList<>();

        read(list, inputLocation);
        writeCustomersInOrder(list, "SpaceX", outputLocation);
        writePayloadsByOrder(list, outputLocation);
    }
}