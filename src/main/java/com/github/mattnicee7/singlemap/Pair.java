package com.github.mattnicee7.singlemap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
@Setter
public class Pair<F, S> {

    private final F first;
    private final S second;

    public static <F, S> Pair<F, S> of(@NotNull F first, @NotNull S second) {
        return new Pair<>(first, second);
    }

}
