package com.github.mattnicee7.mattlib.adapter;

import org.jetbrains.annotations.NotNull;

public interface Restorable<V, K> {

    V restore(@NotNull K k);

}
