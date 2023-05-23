import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateParser {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(""
            + "[d'st' MMMM yyyy]"
            + "[d'nd' MMMM yyyy]"
            + "[d'rd' MMMM yyyy]"       //Could use regex for this 
            + "[d'th' MMMM yyyy]"
            + "[dd/MM/yyyy]"
            + "[dd-MM-yyyy]"
    );

    public static LocalDate parseDate(String dateString) throws DateTimeParseException {
        try {
            return LocalDate.parse(dateString, formatter); //Using LocalDate acts as validation e.g it will not accept a day past 31 - if the 29th Feb is entered on a year
            // that isn't a leap year it will enter the day of week for the 28th instead.
        } catch (DateTimeParseException ex) {
            throw new DateTimeParseException("Invalid date format: " + dateString, dateString, 0);
        }
    }
}
