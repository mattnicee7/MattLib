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

package com.github.mattnicee7.mattlib.logger;

import com.github.mattnicee7.mattlib.date.DateUtil;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class Logger {

    /**
     * Log a message with the {@link LogLevel} level.
     *
     * @param logLevel
     *        The {@link LogLevel} level.
     *
     * @param message
     *        The message to log.
     */
    public void log(@NotNull LogLevel logLevel, @NotNull String message) {
        System.out.println(logLevel.getName() + ": " + message);
    }

    /**
     * Log a message with the {@link LogLevel} level and timestamp.
     *
     * @param logLevel
     *        The {@link LogLevel} level.
     *
     * @param message
     *        The message to log.
     *
     * @param timeStamp
     *        If you want timestamp to be added to the log message.
     * */
    public void log(@NotNull LogLevel logLevel, @NotNull String message, boolean timeStamp) {
        if (!timeStamp) {
            log(logLevel, message);
            return;
        }

        System.out.println(DateUtil.getNowTimeStamp() + " " + logLevel.getName() + ": " + message);
    }

    /**
     * Log a message with {@link LogLevel} level, timestamp and yours {@link DateTimeFormatter}.
     *
     * @param logLevel
     *        The {@link LogLevel} level.
     *
     * @param message
     *        The message to log.
     *
     * @param timeStamp
     *        If you want timestamp to be added to the log message.
     *
     * @param dateTimeFormatter
     *        The {@link DateTimeFormatter} to use.
     * */
    public void log(@NotNull LogLevel logLevel, @NotNull String message, boolean timeStamp, @NotNull DateTimeFormatter dateTimeFormatter) {
        if (!timeStamp) {
            log(logLevel, message);
            return;
        }

        System.out.println(DateUtil.getNowTimeStamp(dateTimeFormatter) + " " + logLevel.getName() + ": " + message);
    }

}
