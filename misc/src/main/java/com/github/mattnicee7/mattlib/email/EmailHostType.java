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

package com.github.mattnicee7.mattlib.email;

import lombok.AccessLevel;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * Enum responsible to storage the all options of email-hosts to use.
 * */
@Getter(AccessLevel.PACKAGE)
public enum EmailHostType {

    GMAIL("smtp.gmail.com", "465");

    private final String smtp;
    private final String port;

    EmailHostType(String smtp, String port) {
        this.smtp = smtp;
        this.port = port;
    }

    /**
     * It takes a string and returns an enum value if the string matches the enum value's name
     *
     * @param emailHostTypeString
     *        The string representation of the email host type.
     *
     * @return The host type if it matches, null otherwise.
     */
    @Nullable
    public EmailHostType of(@NotNull String emailHostTypeString) {
        return Arrays.stream(values())
                .filter(emailHostType -> emailHostType.toString().equalsIgnoreCase(emailHostTypeString))
                .findFirst()
                .orElse(null);
    }

}
