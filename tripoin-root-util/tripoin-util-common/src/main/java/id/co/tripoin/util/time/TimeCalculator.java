package id.co.tripoin.util.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created on 9/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TimeCalculator {
    public TimeCalculator() {
    }

    public static boolean calculateExpiryDate(Date p_DateToVerify, Date p_DateFromDB) {
        return p_DateToVerify.compareTo(p_DateFromDB) < 0;
    }

    public static Date addMinutesToDate(int minutes, Date beforeTime) {
        long ONE_MINUTE_IN_MILLIS = 60000L;
        long curTimeInMs = beforeTime.getTime();
        Date afterAddingMins = new Date(curTimeInMs + (long)minutes * 60000L);
        return afterAddingMins;
    }

    public static int getDaysBetweenTwoDates(Date p_DateStart, Date p_DateEnd) {
        GregorianCalendar cal1 = new GregorianCalendar();
        GregorianCalendar cal2 = new GregorianCalendar();
        cal1.setTime(p_DateStart);
        cal2.setTime(p_DateEnd);
        return (int)((cal1.getTime().getTime() - cal2.getTime().getTime()) / 86400000L);
    }

    public static Date addNDaysToDate(int p_NumberOfDaysToAdd, Date p_DateToModify) {
        Calendar c = Calendar.getInstance();
        c.setTime(p_DateToModify);
        c.add(5, p_NumberOfDaysToAdd);
        return c.getTime();
    }
}
