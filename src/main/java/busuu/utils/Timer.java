package busuu.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer {

    private String startTime;
    private int timerLength;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Timer(int lengthInSecs) {
        this.timerLength = lengthInSecs;
        this.startTime = getCurrentDate();
    }

    public boolean expired() {
        return (long) this.timerLength < getTimeDiffInSeconds(startTime);
    }

    public int lengthWaited() {
        return (int) getTimeDiffInSeconds(startTime);
    }

    private String getCurrentDate() {
        Date date = new Date();
        return dateFormat.format(date).toString();
    }

    private long getTimeDiffInSeconds(String dateTimeStart) {
        long diff = 0;
        try {
            Date startDate = dateFormat.parse(dateTimeStart);
            Date endDate = new Date();
            diff = endDate.getTime() - startDate.getTime();
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return diff/1000;
    }

    public static void pause(long millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
