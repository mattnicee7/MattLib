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

package com.github.mattnicee7.time;

import com.github.mattnicee7.singlemap.Pair;
import org.jetbrains.annotations.NotNull;

public class TimeFormatterBuilder {

    private static final long YEAR_IN_SECONDS = 31104000L;
    private static final long MONTH_IN_SECONDS = 2592000;
    private static final long WEEK_IN_SECONDS = 604800L;
    private static final long DAY_IN_SECONDS = 86400L;
    private static final long HOUR_IN_SECONDS = 3600L;
    private static final long MINUTE_IN_SECONDS = 60L;
    private static final long SECOND_IN_SECONDS = 1;

    private TimeFormatter timeFormatter;

    public TimeFormatterBuilder() {
        timeFormatter = new TimeFormatter();
        timeFormatter.getYear().setTimeInSecond(YEAR_IN_SECONDS);
        timeFormatter.getMonth().setTimeInSecond(MONTH_IN_SECONDS);
        timeFormatter.getWeek().setTimeInSecond(WEEK_IN_SECONDS);
        timeFormatter.getDay().setTimeInSecond(DAY_IN_SECONDS);
        timeFormatter.getHour().setTimeInSecond(HOUR_IN_SECONDS);
        timeFormatter.getMinute().setTimeInSecond(MINUTE_IN_SECONDS);
        timeFormatter.getSecond().setTimeInSecond(SECOND_IN_SECONDS);
    }

    public static TimeFormatter getDefaultTimeFormatter() {
        return new TimeFormatter(
                TimeFormat.of(YEAR_IN_SECONDS, " year", " years"),
                TimeFormat.of(MONTH_IN_SECONDS, " month", " months"),
                TimeFormat.of(WEEK_IN_SECONDS, " week", " weeks"),
                TimeFormat.of(DAY_IN_SECONDS, " day", " days"),
                TimeFormat.of(HOUR_IN_SECONDS, " hour", " hours"),
                TimeFormat.of(MINUTE_IN_SECONDS, " minute", " minutes"),
                TimeFormat.of(SECOND_IN_SECONDS, " second", " seconds")
        );
    }

    public TimeFormatterBuilder setYearFormatter(@NotNull Pair<String, String> singularAndPlural) {
        timeFormatter.getYear().setSingularAndPlural(singularAndPlural);
        return this;
    }

    public TimeFormatterBuilder setYearFormatter(@NotNull String singular, @NotNull String plural) {
        return setYearFormatter(Pair.of(singular, plural));
    }

    public TimeFormatterBuilder setMonthFormatter(@NotNull Pair<String, String> singularAndPlural) {
        timeFormatter.getMonth().setSingularAndPlural(singularAndPlural);
        return this;
    }

    public TimeFormatterBuilder setMonthFormatter(@NotNull String singular, @NotNull String plural) {
        return setMonthFormatter(Pair.of(singular, plural));
    }

    public TimeFormatterBuilder setWeekFormatter(@NotNull Pair<String, String> singularAndPlural) {
        timeFormatter.getWeek().setSingularAndPlural(singularAndPlural);
        return this;
    }

    public TimeFormatterBuilder setWeekFormatter(@NotNull String singular, @NotNull String plural) {
        return setWeekFormatter(Pair.of(singular, plural));
    }

    public TimeFormatterBuilder setDayFormatter(@NotNull Pair<String, String> singularAndPlural) {
        timeFormatter.getDay().setSingularAndPlural(singularAndPlural);
        return this;
    }

    public TimeFormatterBuilder setDayFormatter(@NotNull String singular, @NotNull String plural) {
        return setDayFormatter(Pair.of(singular, plural));
    }

    public TimeFormatterBuilder setHourFormatter(@NotNull Pair<String, String> singularAndPlural) {
        timeFormatter.getHour().setSingularAndPlural(singularAndPlural);
        return this;
    }

    public TimeFormatterBuilder setHourFormatter(@NotNull String singular, @NotNull String plural) {
        return setHourFormatter(Pair.of(singular, plural));
    }

    public TimeFormatterBuilder setMinuteFormatter(@NotNull Pair<String, String> singularAndPlural) {
        timeFormatter.getMinute().setSingularAndPlural(singularAndPlural);
        return this;
    }

    public TimeFormatterBuilder setMinuteFormatter(@NotNull String singular, @NotNull String plural) {
        return setMinuteFormatter(Pair.of(singular, plural));
    }

    public TimeFormatterBuilder setSecondFormatter(@NotNull Pair<String, String> singularAndPlural) {
        timeFormatter.getSecond().setSingularAndPlural(singularAndPlural);
        return this;
    }

    public TimeFormatterBuilder setSecondFormatter(@NotNull String singular, @NotNull String plural) {
        return setSecondFormatter(Pair.of(singular, plural));
    }

    public TimeFormatter build() {
        return timeFormatter;
    }

}
