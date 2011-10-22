package clan.blue.droid.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    
    public static String rightNowToDateStringFull() {
        return timeInMillisecondsToDateStringFull(System.currentTimeMillis());
    }
    
    public static String timeInMillisecondsToDateStringFull(long timeInMilliseconds) {
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_FORMAT_PATTERN);
        Date date = timeInMillisecondsToDate(timeInMilliseconds);
        formatter.format(date);
        return formatter.format(date);
    }
    
    protected static Date timeInMillisecondsToDate(long timeInMilliseconds) {
        Date date = new Date(timeInMilliseconds);
        return date;
    }
    
    public static final String DEFAULT_FORMAT_PATTERN = "EEEE, MMMM dd, yyyy HH:mm:ss.SSS";
}
