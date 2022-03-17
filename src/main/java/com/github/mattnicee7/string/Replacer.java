package com.github.mattnicee7.string;

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
