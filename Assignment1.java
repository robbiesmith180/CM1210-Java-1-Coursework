
/*
 * Name: Robbie Smith
 * Student number: C22026075
 */

public class Assignment1 {

    /*
     * A method to find the day-of-week for a date.
     *
     * Arguments:
     * `date` -- the SimpleDate for which the day-of-week is to be found.
     *
     * Return value:
     * A String representing the day of week. The day of week should be
     * expressed as a three-letter abbreviation; in other words, this method
     * returns one of:
     *   "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
     */
    public static String dayOfWeek(SimpleDate date) {
        // TO BE COMPLETED
        int day = date.getDay();
        int m = date.getMonth();
        int y = date.getYear();

        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int C = y % 100;
        int D = y / 100;

        int W = (13 * (m + 1)) / 5;
        int X = C / 4;
        int Y = D / 4;

        int Z = W + X + Y + day + C - 2 * D;
        int day1 = Z % 7;
        if (day1 < 0) {
            day1 += 7;
        }

        //DayOfWeek.values()
        String[] daysOfTheWeek = {"Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri"};
        return daysOfTheWeek[day1];


    }

    /*
     * Given a set of dates, this method will count the number of dates in the
     * set that fall on a particular day-of-week.
     *
     * Arguments:
     * `dates` -- an array of SimpleDate objects
     * `dayOfWeek` -- a String representing the day of week ("Mon" to "Sun")
     *
     * Return value:
     * An integer giving the number of dates that fell on `dayOfWeek`.
     */


    public static int countDatesOnDay(SimpleDate[] dates, String dayOfWeek) {
        // TO BE COMPLETED
        int count = 0;
        for (int i = 0; i < dates.length; i++) {
            if (dayOfWeek(dates[i]).equals(dayOfWeek)) {
                count++;
            }

        }
        return count;
    }

    /*
     * A method to find the most frequent day-of-week among a collection of
     * dates.
     *
     * Arguments:
     * `dates` -- an array of SimpleDate objects
     *
     * Return value:
     * If the array `dates` is empty, then this method should return the null
     * reference. Otherwise, the method should return the three-letter
     * abbreviation ("Mon", "Tue", etc.) of the day-of-week that was most
     * frequent.
     * In the case that there is a tie for the most-frequent day-of-week,
     * priority should be given to the day-of-week that comes earliest in the
     * week. (For this method, "Mon" is assumed to be the first day of the
     * week.)
     * For example, if there were a tie between Tuesday, Wednesday, and Sunday,
     * the method should return "Tue".
     */


    public static String mostFrequentDayOfWeek(SimpleDate[] dates) {
        // TO BE COMPLETED
        if (dates.length == 0) {
            return null;
        }

        int[] daysOfTheWeek = new int[7];

        for (SimpleDate date : dates) {
            int day = switch (Assignment1.dayOfWeek(date)) {
                //Enhanced switch case - uses lambda syntax
                case "Mon" -> 0;
                case "Tue" -> 1;
                case "Wed" -> 2;
                case "Thu" -> 3;
                case "Fri" -> 4;
                case "Sat" -> 5;
                case "Sun" -> 6;
                default -> throw new RuntimeException("Invalid Number - cannot find day of number");
            };
            daysOfTheWeek[day]++;
        }


        int count = 0;
        int max = 0;

        for (int i = 0; i < daysOfTheWeek.length; i++) {
            if (daysOfTheWeek[i] > count) {
                count = daysOfTheWeek[i];
                max = i;
            }
        }

        String[] eachDay = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        return eachDay[max];


    }


}

