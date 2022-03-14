package com.github.mattnicee7.singlemap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
@Setter
public class Triple<F, S, T> {

    private F first;
    private S second;
    private T third;

    public static <F, S, T> Triple<F, S, T> of(@NotNull F first, @NotNull S second, @NotNull T third) {
        return new Triple<>(first, second, third);
    }

}
