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

package com.github.mattnicee7.mattlib.string;

import java.util.function.Function;

public class StringUtil {

    /**
     * Not instantiable.
     * */
    private StringUtil() {
        throw new UnsupportedOperationException("This class is not instantiable");
    }

    /**
     *
     * */
    public static String format(String message, Function<String, String> format) {
        return format.apply(message);
    }

    /**
     * If the message is empty, return the default message, otherwise return the message
     *
     * @param message
     *        The message to check if it's empty.
     *
     * @param defaultMessage
     *        The message to return if the message is empty.
     *
     * @return The message if it is not empty, otherwise the defaultMessage.
     */
    public static String ifEmpty(String message, String defaultMessage) {
        return message.isEmpty() ? defaultMessage : message;
    }

}
