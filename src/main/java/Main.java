import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Create a scanner object
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;

        while (alarmTime == null) {
            try {
//        Get Time from user
                System.out.println("Enter a (HH:MM:SS): ");
                String inputTime = scanner.nextLine();

//        Parse the input time
                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for: " + alarmTime.format(formatter));

            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please use HH:MM:SS");
            }
        }

//        Runnable AlarmClock
        AlarmClock alarmClock = new AlarmClock(alarmTime);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();


        scanner.close();
    }
}
