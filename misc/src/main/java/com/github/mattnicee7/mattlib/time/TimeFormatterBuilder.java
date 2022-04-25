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

import com.github.mattnicee7.mattlib.singlemap.Pair;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * A class that builds a {@link TimeFormatter}.
 * */
@NoArgsConstructor
public class TimeFormatterBuilder {

    private final TimeFormatter timeFormatter = new TimeFormatter();

    public static TimeFormatter getDefaultTimeFormatter() {
        return new TimeFormatter(
                TimeFormat.of(" year", " years"),
                TimeFormat.of(" month", " months"),
                TimeFormat.of(" week", " weeks"),
                TimeFormat.of(" day", " days"),
                TimeFormat.of(" hour", " hours"),
                TimeFormat.of(" minute", " minutes"),
                TimeFormat.of(" second", " seconds")
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
