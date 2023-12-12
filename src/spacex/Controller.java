package spacex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Controller {
    static String csvFileHeader;

    private static Mission parse(String line) throws IllegalArgumentException {
        String[] str = line.split(",");
        String[] column = new String[16];

        // copy data into larger array to fix issues with splitting
        for (int i = 0; i < str.length; i++)
            column[i] = str[i];

        // null values at the end set to empty
        if (str.length < column.length) {
            for (int i = str.length; i < column.length; i++) {
                column[i] = "";
            }
        }

        // TODO: Update the data with the values in the CSV file
        String flightNumber = column[0];
        Date launchDate = new Date(column[1]);
        Time launchTime = new Time(column[2]);
        String launchSite = column[3];
        String vehicleType = column[4];
        double mass = Double.parseDouble(column[5]);
        Payload payload = new Payload(column[6], column[7], column[8]);
        Customer customer = new Customer(column[9], column[10], column[11]);
        String missionOutcome = column[12];
        String failureReason = column[13];
        String landingType = column[14];
        String landingOutcome = column[15];

        // TODO: return Mission object using the builder pattern
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
        File file = new File(inputLocation);
        Scanner input = new Scanner(file);

        Mission missionData;

        // TODO: read in mission data and table header
        csvFileHeader = input.nextLine();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            missionData = parse(line);
            list.add(missionData);
        }

        input.close();
    }

    public static void writeCustomersInOrder(List<Mission> list, String customer, String outputLocation)
            throws FileNotFoundException {
        String csvLocation = outputLocation + File.separator + customer + ".csv";
        String txtLocation = outputLocation + File.separator + customer + ".txt";
        File csvFile = new File(csvLocation);
        File txtFile = new File(txtLocation);
        PrintStream csvStream = new PrintStream(csvFile);
        PrintStream txtStream = new PrintStream(txtFile);

        // TODO: You may choose to use one, both or none of these suggested identifiers
        Customer missionCustomer;
        Mission mission;

        // TODO: get mission data with customer name.
        for (Mission m : list) {
            if (m.getCustomer().getName().equals(customer)) {
                csvStream.println(m.toCsvString());
                txtStream.println(m.toTxtString());
            }
        }

        csvStream.close();
        txtStream.close();

    }

    public static void writePayloadsByOrder(List<Mission> list, String outputLocation) throws FileNotFoundException {
        String csvLocation = outputLocation + File.separator + "ordered_payload.csv";
        String txtLocation = outputLocation + File.separator + "ordered_payload.txt";
        File csvFile = new File(csvLocation);
        File txtFile = new File(txtLocation);
        PrintStream csvStream = new PrintStream(csvFile);
        PrintStream txtStream = new PrintStream(txtFile);

        // TODO: sort payloads and order in a separate output file.
        List<Payload> payloads = new ArrayList<>();

        for (Mission m : list) {
            payloads.add(m.getPayload());
        }

        payloads.sort(Comparator.comparing(Payload::getName));

        for (Payload p : payloads) {
            csvStream.println(p.toCsvString());
            txtStream.println(p.toTxtString());
        }

        csvStream.close();
        txtStream.close();
    }

    public static void intro() {
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

        String outputLocation = "." + File.separator + "results";

        String inputLocation = "." + File.separator + "data"
                + File.separator + "spacex_mission_data.csv";

        System.out.println();
        // TODO: print intro to console
        intro();

        // TODO: set list for data entry
        List<Mission> list = new ArrayList<>();

        // TODO: set locations, read and write files
        read(list, inputLocation);

        writeCustomersInOrder(list, "Elon Musk", outputLocation);

        writePayloadsByOrder(list, outputLocation);

        // EXAMPLES: You can delete these, they are just examples
        System.out.println();
        Date date1 = new Date(4, Month.JUN, 10);
        Date date2 = new Date(8, Month.OCT, 12);

        System.out.println("Date 1 Object: " + date1);
        System.out.println("Date 2 Object: " + date2);
    }
}