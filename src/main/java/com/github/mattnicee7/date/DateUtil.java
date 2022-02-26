package com.github.mattnicee7.date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 */
public class DateUtil {

    /**
     *
     */
    private static final SimpleDateFormat DEFAULT_SIMPLE_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    /**
     *
     */
    public static String getNowTimeStamp() {
        return "";
    }

    /**
     *
     */
    public static String getNowTimeStamp(SimpleDateFormat simpleDateFormat) {
        return "";
    }

    /**
     *
     */
    public static String getTimeStamp(Instant instant) {
        return "";
    }

    /**
     *
     */
    public static String getTimeStamp(Instant instant, SimpleDateFormat simpleDateFormat) {
        return "";
    }

    /**
     *
     */
    public Period getDifferenceBetween(LocalDate date1, LocalDate date2) {
        return Period.between(date1, date2);
    }

}
