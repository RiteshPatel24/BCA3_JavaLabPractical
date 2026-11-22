import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAddSubtractDemo {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("----- Current Date & Time -----");
        System.out.println(currentDateTime.format(formatter));

        // Add days
        LocalDateTime addDays = currentDateTime.plusDays(15);
        System.out.println("\n----- After Adding 15 Days -----");
        System.out.println(addDays.format(formatter));

        // Subtract days
        LocalDateTime subDays = currentDateTime.minusDays(10);
        System.out.println("\n----- After Subtracting 10 Days -----");
        System.out.println(subDays.format(formatter));

        // Add months
        LocalDateTime addMonths = currentDateTime.plusMonths(3);
        System.out.println("\n----- After Adding 3 Months -----");
        System.out.println(addMonths.format(formatter));

        // Subtract months
        LocalDateTime subMonths = currentDateTime.minusMonths(2);
        System.out.println("\n----- After Subtracting 2 Months -----");
        System.out.println(subMonths.format(formatter));

        // Add years
        LocalDateTime addYears = currentDateTime.plusYears(1);
        System.out.println("\n----- After Adding 1 Year -----");
        System.out.println(addYears.format(formatter));

        // Subtract years
        LocalDateTime subYears = currentDateTime.minusYears(5);
        System.out.println("\n----- After Subtracting 5 Years -----");
        System.out.println(subYears.format(formatter));

        // Add hours, minutes
        LocalDateTime addHoursMinutes = currentDateTime.plusHours(5).plusMinutes(30);
        System.out.println("\n----- After Adding 5 Hours 30 Minutes -----");
        System.out.println(addHoursMinutes.format(formatter));

        // Combined: Add days and subtract months together
        LocalDateTime combined = currentDateTime.plusDays(20).minusMonths(1);
        System.out.println("\n----- After Adding 20 Days & Subtracting 1 Month -----");
        System.out.println(combined.format(formatter));
    }
}
