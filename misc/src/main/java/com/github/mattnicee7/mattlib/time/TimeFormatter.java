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

package com.github.mattnicee7.mattlib.time;

import lombok.AccessLevel;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Map.Entry;

/**
 * It converts a number of milliseconds into a human readable format.
 */
@Getter(AccessLevel.PACKAGE)
public class TimeFormatter {

    private TimeFormat year = new TimeFormat();
    private TimeFormat month = new TimeFormat();
    private TimeFormat week = new TimeFormat();
    private TimeFormat day = new TimeFormat();
    private TimeFormat hour = new TimeFormat();
    private TimeFormat minute = new TimeFormat();
    private TimeFormat second = new TimeFormat();

    public TimeFormatter() {
        applyTimeInTimeFormats();
    }

    public TimeFormatter(
            @NotNull TimeFormat year, @NotNull TimeFormat month,
            @NotNull TimeFormat week, @NotNull TimeFormat day,
            @NotNull TimeFormat hour, @NotNull TimeFormat minute,
            @NotNull TimeFormat second) {
        this.year = year;
        this.month = month;
        this.week = week;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        applyTimeInTimeFormats();
    }

    /**
     * Format the time in milliseconds to a string.
     *
     * Credits: <a href="https://github.com/ViiictorXD">ViiictorXD</a>, (Thanks so much, Viiictor).
     *
     * @param timeInMillis
     *        The time in milliseconds.
     *
     * @return The formatted time.
     */
    public String format(long timeInMillis) {
        final List<TimeFormat> values = Arrays.asList(
                year, month, week, day, hour, minute, second
        );
        final Map<TimeFormat, Integer> timeFormatMap = new LinkedHashMap<>();

        long leftTime = TimeUnit.MILLISECONDS.toSeconds(timeInMillis);
        for (TimeFormat value : values) {
            if (leftTime >= value.getTimeInSecond()) {
                int durationInCurrentTime = (int) (leftTime / value.getTimeInSecond());
                leftTime %= value.getTimeInSecond();

                timeFormatMap.put(value, durationInCurrentTime);
            }
        }

        final StringBuilder stringBuilder = new StringBuilder();
        final Set<Entry<TimeFormat, Integer>> entries = timeFormatMap.entrySet();
        int size = entries.size();

        int index = 1;

        for (Entry<TimeFormat, Integer> entry : entries) {
            final TimeFormat key = entry.getKey();
            final Integer value = entry.getValue();

            stringBuilder.append(value)
                    .append(value == 1 ? key.getSingular() : key.getPlural());

            if (index == size - 1)
                stringBuilder.append(" & ");
            else if (index != size)
                stringBuilder.append(", ");

            index++;
        }

        return stringBuilder.toString();
    }

    /**
     * > It sets the time in seconds for each of the time formats
     */
    private void applyTimeInTimeFormats() {
        this.year.setTimeInSecond(31104000L);
        this.month.setTimeInSecond(2592000L);
        this.week.setTimeInSecond(604800L);
        this.day.setTimeInSecond(86400L);
        this.hour.setTimeInSecond(3600L);
        this.minute.setTimeInSecond(60L);
        this.second.setTimeInSecond(1L);
    }

}
