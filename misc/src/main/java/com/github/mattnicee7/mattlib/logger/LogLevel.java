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

import com.github.mattnicee7.mattlib.console.ConsoleUtil;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

@Getter
public enum LogLevel {

    WARNING("[WARNING]" + ConsoleUtil.ANSI_RESET, ConsoleUtil.ANSI_RED_BACKGROUND),
    INFO("[INFO]" + ConsoleUtil.ANSI_RESET, ConsoleUtil.ANSI_CYAN_BACKGROUND),
    FINE("[FINE]" + ConsoleUtil.ANSI_RESET, ConsoleUtil.ANSI_GREEN_BACKGROUND);

    private final String name;
    private final String backgroundColor;

    LogLevel(@NotNull String name, @Nullable String backgroundColor) {
        this.name = name;
        this.backgroundColor = backgroundColor;
    }

    @Nullable
    public static LogLevel of(@NotNull String logLevelString) {
        return Arrays.stream(values())
                .filter(logLevel -> logLevel.name.equalsIgnoreCase(logLevelString))
                .findFirst()
                .orElse(null);
    }

}
