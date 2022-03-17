package com.github.mattnicee7.mattlib.adapter;

import org.jetbrains.annotations.NotNull;

public interface Adapter<K, V> {

    V adapt(@NotNull K k);

}
