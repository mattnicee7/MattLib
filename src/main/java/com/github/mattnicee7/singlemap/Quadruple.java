package com.github.mattnicee7.singlemap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
@Setter
public class Quadruple<F, S, T, Q> {

    private final F first;
    private final S second;
    private final T third;
    private final Q fourth;

    public static <F, S, T, Q> Quadruple<F, S, T, Q> of(@NotNull F first, @NotNull S second, @NotNull T third, @NotNull Q fourth) {
        return new Quadruple<>(first, second, third, fourth);
    }

}
