package com.github.mattnicee7.logger;

import com.github.mattnicee7.console.ConsoleUtil;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public enum LogLevel {

    WARNING("[WARNING]" + ConsoleUtil.ANSI_RESET, ConsoleUtil.ANSI_RED_BACKGROUND),
    INFO("[INFO]" + ConsoleUtil.ANSI_RESET, ConsoleUtil.ANSI_CYAN_BACKGROUND),
    FINE( "[FINE]" + ConsoleUtil.ANSI_RESET, ConsoleUtil.ANSI_GREEN_BACKGROUND);

    private final String name;

    private final String color;

    LogLevel(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Nullable
    public static LogLevel of(@NotNull String logLevelString) {
        for (LogLevel logLevel : values()) {
            if (String.valueOf(logLevel).equalsIgnoreCase(logLevelString))
                return logLevel;
        }

        return null;
    }

}
