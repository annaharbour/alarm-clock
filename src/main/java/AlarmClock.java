import java.time.LocalTime;

public class AlarmClock implements Runnable {
    private final LocalTime alarmTime;

    //    Constructor
    public AlarmClock(LocalTime alarmTime) {
        this.alarmTime = alarmTime;
    }

    @Override
    public void run() {
        while (LocalTime.now().isBefore(alarmTime)) {
            try {
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();
                int hours = now.getHour();
                int minutes = now.getMinute();
                int seconds = now.getSecond();
                System.out.printf("\r%02d:%02d:%02d", hours, minutes, seconds);

            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
        System.out.println("\nBEEP BEEP BEEP!");
    }
}
