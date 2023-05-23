public class AssignmentTest{
    public static void main ( String[] args ){
        SimpleDate date = new SimpleDate(2004, 7, 18); //Sunday 
        
        //Testing dayOfWeek method
        String dayOfWeek = Assignment1.dayOfWeek(date);
        System.out.println(dayOfWeek);

        //Creating array of dates
        SimpleDate[] dates = new SimpleDate[7];
        dates[0] = new SimpleDate(2004, 7, 18); //Sunday
        dates[1] = new SimpleDate(2005, 10, 5); //Wednesday
        dates[2] = new SimpleDate(1968, 7, 18); //Thursday
        dates[3] = new SimpleDate(1978, 1, 27); //Friday
        dates[4] = new SimpleDate(2004, 2, 25); //Wednesday
        dates[5] = new SimpleDate(2023, 2, 27); //Monday
        dates[6] = new SimpleDate(2023, 6, 12);//Monday

        
        //Testing countDatesOnDay method
        int count = Assignment1.countDatesOnDay(dates, dayOfWeek);
        System.out.println(count);

        //Testing mostFrequentDayOfWeek method
        String frequent = Assignment1.mostFrequentDayOfWeek(dates);
        System.out.println(frequent);
    }
    
}
