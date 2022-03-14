package com.github.mattnicee7.logger;

import com.github.mattnicee7.date.DateUtil;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class Logger {

    public void log(@NotNull LogLevel logLevel, @NotNull String message) {
        System.out.println(logLevel.getName() + ": " + message);
    }

    public void log(@NotNull LogLevel logLevel, boolean colored, @NotNull String message) {
        if (!colored) {
            log(logLevel, message);
            return;
        }

        System.out.println(logLevel.getColor() + logLevel.getName() + ": " + message);
    }

    public void log(@NotNull LogLevel logLevel, @NotNull String message, boolean timeStamp) {
        if (!timeStamp) {
            log(logLevel, message);
            return;
        }

        System.out.println(DateUtil.getNowTimeStamp() + " " + logLevel.getName() + ": " + message);
    }

    public void log(@NotNull LogLevel logLevel, @NotNull String message, boolean timeStamp, @NotNull DateTimeFormatter dateTimeFormatter) {
        if (!timeStamp) {
            log(logLevel, message);
            return;
        }

        System.out.println(DateUtil.getNowTimeStamp(dateTimeFormatter) + " " + logLevel.getName() + ": " + message);
    }

}
