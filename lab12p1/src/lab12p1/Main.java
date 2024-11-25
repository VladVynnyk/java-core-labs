package lab12p1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        String dateTimeString = "2023-10-31 15:45";
        String pattern = "yyyy-MM-dd HH:mm";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
            System.out.println("Parsed date and time: " + dateTime);
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing date and time: " + e.getMessage());
        }
    }
}
