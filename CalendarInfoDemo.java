import java.util.Calendar;
import java.util.Locale;

public class CalendarInfoDemo {
    public static void main(String[] args) {

        // Get an instance of Calendar representing the current date/time
        Calendar cal = Calendar.getInstance();

        System.out.println("----- Current Calendar Info -----");
        System.out.println("Full Date/Time: " + cal.getTime());

        System.out.println("\n----- Individual Fields -----");
        System.out.println("Year: " + cal.get(Calendar.YEAR));
        System.out.println("Month (0-based): " + cal.get(Calendar.MONTH));
        System.out.println("Month Name: " + cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
        System.out.println("Day of Month: " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("Day of Week (1=Sun): " + cal.get(Calendar.DAY_OF_WEEK));
        System.out.println("Day of Week Name: " + cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
        System.out.println("Day of Year: " + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("Week of Month: " + cal.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Week of Year: " + cal.get(Calendar.WEEK_OF_YEAR));

        System.out.println("\n----- Time Fields -----");
        System.out.println("Hour (12-hr): " + cal.get(Calendar.HOUR));
        System.out.println("Hour (24-hr): " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute: " + cal.get(Calendar.MINUTE));
        System.out.println("Second: " + cal.get(Calendar.SECOND));
        System.out.println("AM/PM: " + (cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM"));

        System.out.println("\n----- Other Info -----");
        System.out.println("Is Leap Year: " + ((java.util.GregorianCalendar) cal).isLeapYear(cal.get(Calendar.YEAR)));
        System.out.println("Max Days in this Month: " + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("Time Zone: " + cal.getTimeZone().getID());

        System.out.println("\n----- Manipulating the Calendar -----");
        cal.add(Calendar.DAY_OF_MONTH, 10);   // add 10 days
        System.out.println("Date after adding 10 days: " + cal.getTime());

        cal.add(Calendar.MONTH, -2);          // subtract 2 months
        System.out.println("Date after subtracting 2 months: " + cal.getTime());

        System.out.println("\n----- Setting a Specific Date -----");
        Calendar customCal = Calendar.getInstance();
        customCal.set(2025, Calendar.DECEMBER, 25);  // Note: month is 0-based, so DECEMBER = 11
        System.out.println("Custom Date Set: " + customCal.getTime());
        System.out.println("Day of Week for Custom Date: " +
                customCal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
    }
}
