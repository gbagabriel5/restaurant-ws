package com.example.Restaurant.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public final class DateTimeUtils {

    public static final int LENGTH_TIME_HHMMSS = 8;
    public static final int LENGTH_TIME_HHMM = 5;

    protected static final Date START_DATE = new Date(Time.valueOf("00:00:00").getTime());

    private DateTimeUtils() {
    }

    public static Date convertStringDDMMYYYYToDate(String stringDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.parse(stringDate);
    }

    public static String converteDateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(date);
    }

    public static Date changeTimeToStartTimeDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date changeTimeToEndTimeDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    public static String convertDateToHHMMSS(Date date) {
        if (date != null) {
            return new SimpleDateFormat("HH:mm:ss").format(date);
        }
        return null;
    }

    /**
     *
     * @return format 'yyyy-MM-dd'T'HH:mm:ss.SSS'
     */
    public static String getCurrentLogstashTimestamp() {
        Instant instant = Instant.now();
        return instant.toString();
    }

    public static String convertStrHHMMToHHMMSS(String time) {
        if (time.length() == LENGTH_TIME_HHMM) {
            return time + ":00";
        }
        return time;
    }

    public static Date convertHHMMSSToDate(String hhmmss) {
        return new Date(Time.valueOf(hhmmss).getTime());
    }

    public static Date convertSecondsToDate(long seconds) {
        long milliseconds = seconds * 1000L;
        return new Date(START_DATE.getTime() + milliseconds);
    }

    public static long convertDateToSeconds(Date date) {
        if (date == null) {
            return 0L;
        }
        date.setTime((date.getTime() - START_DATE.getTime()) / 1000L);
        return date.getTime();
    }
}