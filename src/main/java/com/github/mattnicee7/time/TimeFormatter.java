package com.github.mattnicee7.time;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public class TimeFormatter {

    private TimeFormat year = new TimeFormat();
    private TimeFormat month = new TimeFormat();
    private TimeFormat week = new TimeFormat();
    private TimeFormat day = new TimeFormat();
    private TimeFormat hour = new TimeFormat();
    private TimeFormat minute = new TimeFormat();
    private TimeFormat second = new TimeFormat();

    /*
     Credits: https://github.com/ViiictorXD/ParkourBR/blob/development/src/main/java/com/rukko/parkour/backend/format/FormatTime.java.
     Thanks so much ViictorXD.
     */
    public String format(long millis) {
        final List<TimeFormat> values = Arrays.asList(
                year, month, week, day, hour, minute, second
        );
        final Map<TimeFormat, Integer> timeFormatMap = new LinkedHashMap<>();

        long leftTime = TimeUnit.MILLISECONDS.toSeconds(millis);
        for (TimeFormat value : values) {
            if (leftTime >= value.getTimeInSecond()) {
                int durationInCurrentTime = (int) (leftTime / value.getTimeInSecond());
                leftTime %= value.getTimeInSecond();

                timeFormatMap.put(value, durationInCurrentTime);
            }
        }

        final StringBuilder stringBuilder = new StringBuilder();
        Set<Map.Entry<TimeFormat, Integer>> entries = timeFormatMap.entrySet();
        int size = entries.size();

        int index = 1;

        for (Map.Entry<TimeFormat, Integer> entry : entries) {
            TimeFormat key = entry.getKey();
            Integer value = entry.getValue();

            stringBuilder.append(value)
                    .append(value == 1 ? key.getSingular() : key.getPlural());

            if (index == size - 1) {
                stringBuilder.append(" & ");
            } else if (index != size) {
                stringBuilder.append(", ");
            }

            index++;
        }

        return stringBuilder.toString();
    }

    public String format(LocalDateTime localDateTime) {
        return format(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    public String format(Date date) {
        return format(date.getTime());
    }

    public String format(Instant instant) {
        return format(instant.toEpochMilli());
    }

}
