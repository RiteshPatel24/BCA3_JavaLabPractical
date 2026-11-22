import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Locale;

public class GregorianCalendarDemo {
    public static void main(String[] args) {

        // Create a GregorianCalendar with the current date and time
        GregorianCalendar gCal = new GregorianCalendar();

        System.out.println("----- Current Date & Time -----");
        System.out.println(gCal.getTime());

        System.out.println("\n----- Individual Fields -----");
        System.out.println("Year: " + gCal.get(Calendar.YEAR));
        System.out.println("Month (0-based): " + gCal.get(Calendar.MONTH));
        System.out.println("Month Name: " + gCal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
        System.out.println("Day of Month: " + gCal.get(Calendar.DAY_OF_MONTH));
        System.out.println("Day of Week: " + gCal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
        System.out.println("Hour: " + gCal.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute: " + gCal.get(Calendar.MINUTE));
        System.out.println("Second: " + gCal.get(Calendar.SECOND));

        System.out.println("\n----- Creating a Specific Date -----");
        // Constructor: year, month (0-based), day
        GregorianCalendar customDate = new GregorianCalendar(2025, Calendar.DECEMBER, 25);
        System.out.println("Custom Date: " + customDate.getTime());

        System.out.println("\n----- Creating Date with Time -----");
        // Constructor: year, month, day, hour, minute, second
        GregorianCalendar customDateTime = new GregorianCalendar(2026, Calendar.JANUARY, 1, 9, 30, 0);
        System.out.println("Custom Date & Time: " + customDateTime.getTime());

        System.out.println("\n----- Leap Year Check -----");
        int[] yearsToCheck = {2024, 2025, 2026, 2028, 2000, 1900};
        for (int year : yearsToCheck) {
            System.out.println(year + " is Leap Year: " + gCal.isLeapYear(year));
        }

        System.out.println("\n----- Adding/Subtracting Using GregorianCalendar -----");
        GregorianCalendar modifyCal = new GregorianCalendar();
        System.out.println("Before: " + modifyCal.getTime());

        modifyCal.add(Calendar.DAY_OF_MONTH, 45);   // add 45 days
        System.out.println("After adding 45 days: " + modifyCal.getTime());

        modifyCal.add(Calendar.YEAR, -3);           // subtract 3 years
        System.out.println("After subtracting 3 years: " + modifyCal.getTime());

        System.out.println("\n----- Comparing Two Dates -----");
        GregorianCalendar date1 = new GregorianCalendar(2026, Calendar.MARCH, 10);
        GregorianCalendar date2 = new GregorianCalendar(2026, Calendar.AUGUST, 30);

        if (date1.before(date2)) {
            System.out.println("date1 (10-Mar-2026) is before date2 (30-Aug-2026)");
        } else if (date1.after(date2)) {
            System.out.println("date1 is after date2");
        } else {
            System.out.println("Both dates are equal");
        }

        System.out.println("\n----- Getting Min/Max/Actual Values -----");
        System.out.println("Max days in current month: " + gCal.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("Min days in a month: " + gCal.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println("Weeks in current year: " + gCal.getActualMaximum(Calendar.WEEK_OF_YEAR));
    }
}

