/*
 * This file is part of MattLib, licensed under the MIT License.
 *
 *  Copyright (c) mattnicee7
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package com.github.mattnicee7.mattlib.date;

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
     * Not instantiable
     */
    private DateUtil() {
        throw new UnsupportedOperationException("This class is not instantiable");
    }

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
