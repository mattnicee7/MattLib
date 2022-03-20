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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Replacer {

    private final Map<String, Object> replacers = new HashMap<>();

    public Replacer add(String key, Object value) {
        replacers.put(key, value);
        return this;
    }

    public String replace(String message) {
        for (Map.Entry<String, Object> entry : replacers.entrySet()) {
            message = message.replace(entry.getKey(), entry.getValue().toString());
        }

        return message;
    }

    public List<String> replace(@NotNull List<String> messages) {
        final List<String> messagesReplaced = new ArrayList<>();

        for (String message : messages) {
            String messageReplaced = message;
            for (Map.Entry<String, Object> entry : replacers.entrySet()) {
                messageReplaced = messageReplaced.replace(entry.getKey(), entry.getValue().toString());
            }
            messagesReplaced.add(messageReplaced);
        }

        return messagesReplaced;
    }

}
