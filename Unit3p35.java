import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatDemo {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        System.out.println("----- Original Date & Time -----");
        System.out.println(now);

        // Format 1: dd-MM-yyyy
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("\nFormat (dd-MM-yyyy): " + now.format(format1));

        // Format 2: MM/dd/yyyy
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("Format (MM/dd/yyyy): " + now.format(format2));

        // Format 3: yyyy.MM.dd
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        System.out.println("Format (yyyy.MM.dd): " + now.format(format3));

        // Format 4: dd MMM yyyy (e.g., 30 Aug 2026)
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("dd MMM yyyy");
        System.out.println("Format (dd MMM yyyy): " + now.format(format4));

        // Format 5: EEEE, dd MMMM yyyy (full day and month name)
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
        System.out.println("Format (EEEE, dd MMMM yyyy): " + now.format(format5));

        // Format 6: Date with time - dd-MM-yyyy HH:mm:ss
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Format (dd-MM-yyyy HH:mm:ss): " + now.format(format6));

        // Format 7: 12-hour time with AM/PM
        DateTimeFormatter format7 = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");
        System.out.println("Format (12-hour with AM/PM): " + now.format(format7));

        // Formatting just a date (without time)
        LocalDate today = LocalDate.now();
        DateTimeFormatter format8 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\nLocalDate only (dd/MM/yyyy): " + today.format(format8));
    }
}
