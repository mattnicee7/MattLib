package com.github.mattnicee7.mattlib.data;

import java.util.HashMap;
import java.util.Map;

public abstract class Datable {

    private final Map<Object, Object> data = new HashMap<>();

    public void set(Object key, Object value) {
        data.put(key, value);
    }

    public Object get(Object key) {
        return data.get(key);
    }

    public void clear() {
        data.clear();
    }

    public boolean containsKey(Object key) {
        return data.containsKey(key);
    }

}
