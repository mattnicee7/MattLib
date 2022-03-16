package com.github.mattnicee7.replacer;

import java.util.HashMap;
import java.util.Map;

public class Replacer {

    private final Map<String, String> replacers = new HashMap<>();

    public Replacer add(String key, String value) {
        replacers.put(key, value);
        return this;
    }

    public String replace(String message) {
        for (Map.Entry<String, String> entry : replacers.entrySet()) {
            message = message.replace(entry.getKey(), entry.getValue());
        }

        return message;
    }

}
