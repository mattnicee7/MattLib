package com.github.mattnicee7.logger;

import com.github.mattnicee7.console.ConsoleUtil;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum LogLevel {

    WARNING(ConsoleUtil.ANSI_RED_BACKGROUND + "[WARNING]" + ConsoleUtil.ANSI_RESET),
    INFO(ConsoleUtil.ANSI_CYAN_BACKGROUND + "[INFO]" + ConsoleUtil.ANSI_RESET),
    FINE(ConsoleUtil.ANSI_GREEN_BACKGROUND + "[FINE]" + ConsoleUtil.ANSI_RESET);

    @Getter
    private final String name;

    LogLevel(String name) {
        this.name = name;
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
