package com.github.mattnicee7.date;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for dates.
 */
public class DateUtil {

    /**
     * Default time formatter for the time stamps.
     * Example return: 18/01/2004 23:00:00
     */
    private static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Get the now timestamp with the default time formatter.
     *
     * @return The now timestamp formatted with the default time formatter.
     */
    public static String getNowTimeStamp() {
        return DEFAULT_TIME_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * Get the now timestamp with the your time formatter.
     *
     * @param dateTimeFormatter
     *      The yours time formatter
     *
     * @return The now timestamp formatted with your time formatter.
     */
    public static String getNowTimeStamp(@NotNull DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    /**
     * Get timestamp from specified date with the default time formatter.
     *
     * @param localDateTime
     *      The date you want the timestamp.
     *
     * @return The timestamp formatted with default time formatter.
     */
    public static String getTimeStamp(@NotNull LocalDateTime localDateTime) {
        return DEFAULT_TIME_FORMATTER.format(localDateTime);
    }

    /**
     * Get timestamp from specified date with the your time formatter.
     *
     * @param localDateTime
     *      The date you want the timestamp.
     *
     * @param dateTimeFormatter
     *      The yours time formatter
     *
     * @return The timestamp formatted with yours time formatter.
     */
    public static String getTimeStamp(@NotNull LocalDateTime localDateTime, @NotNull DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.format(localDateTime);
    }

}
