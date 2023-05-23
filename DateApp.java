import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class DateApp {

    public static void main(String[] args) {
        //Error checking - Needs to be exactly one command-line argument
        if (args.length != 1) {
            System.err.println("You need to enter precisely one argument.");
            System.exit(1);
        }

        //Extracts given file name from the given command-line argument
        String dateInput = args[0];

        //Checking to see if command line argument is a text file
        if (dateInput.endsWith(".txt")) {
            try {
                ArrayList<SimpleDate> dates = readDatesFromFile(dateInput);
                printDates(dates);

            } catch (IOException e) {
                //If there is an error reading file, prints an error message and exits
                System.err.println("Failed to read file: " + dateInput);
                System.exit(1);
            }
        } else {
            LocalDate date = outputDateFromCmd(dateInput);
            //Prints the date and then output day of week for this date
            System.out.println(date);
            System.out.println("The day of the week for the given date is: " + date.getDayOfWeek());
        }
    }


    public static LocalDate outputDateFromCmd(String dateInput) {
        LocalDate date = DateParser.parseDate(dateInput);

        //Check to see if year is before 1753 as algorithm only works for years after this 
        if (date.getYear() < 1753) {
            throw new IllegalArgumentException("Year must be 1753 or later");
        }
        return date;
    }

    public static ArrayList<SimpleDate> readDatesFromFile(String fileName) throws IOException {
        ArrayList<SimpleDate> dates = new ArrayList<>();
        //Open the file for reading using a BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String dateString;
            //Reads each line of the file 
            while ((dateString = reader.readLine()) != null) {
                LocalDate date = DateParser.parseDate(dateString);
                if (date != null) {
                    //If parse succeeds, add the date to the list
                    dates.add(new SimpleDate(date.getYear(), date.getMonthValue(), date.getDayOfMonth()));
                }
            }
        }
        return dates;
    }

    public static void printDates(ArrayList<SimpleDate> dates) {
        int i = 1;
        for (SimpleDate date : dates) {
            //Repeating code - not good practice
            if (date.getYear() < 1753) {
                throw new RuntimeException("Year must be 1753 or later");
            } else {
                //Use printf statement to format the output cleaner
                System.out.printf("%d. %s = %s\n", i, date, date.dayOfWeek());
                i += 1;
            }
        }
        //Loops through the array to determine most Frequent day and outputs it 
        String mostFrequentDay = SimpleDate.mostFrequentDayOfWeek(dates);
        System.out.println("Most frequent day of week: " + mostFrequentDay);

    }

}


