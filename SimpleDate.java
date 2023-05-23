
/*
 * A simple class to represent a calendar date.
 * Uses a naive representation. This class does not verify that the month and
 * day values are valid.
 *
 * The month is represented by an integer between 1 (January) to 12 (December).
 * The day is represented by an integer, with 1 indicating the first day of
 * the month.
 *
 * This class should NOT be modified for Question 1 of the assessment.
 */


import java.util.ArrayList;

public class SimpleDate {
    private int year;
    private int month;
    private int day;

    public SimpleDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String toString() {
        return String.format("%04d/%02d/%02d", year, month, day);
    }

    public String dayOfWeek() {

        //Algorithm to determine the day of week for a given date
        if (month < 3) {
            month += 12; //Do not need to instantiate these variables as they are being called inside the same class they are created
            year -= 1;
        }
        int century = year % 100;
        int decade = year / 100;

        int W = (13 * (month + 1)) / 5;
        int X = century / 4;
        int Y = decade / 4;

        int Z = W + X + Y + day + century - 2 * decade;
        int day = Z % 7;
        if (day < 0) {
            day += 7;
        }

        String[] daysOfTheWeek = {"Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri"};
        return daysOfTheWeek[day];
    }


    public static String mostFrequentDayOfWeek(ArrayList<SimpleDate> dates) {

        //Use dates.size as the argument is an ArrayList
        if (dates.size() == 0) {
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

