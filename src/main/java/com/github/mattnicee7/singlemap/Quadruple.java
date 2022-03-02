package com.github.mattnicee7.singlemap;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Quadruple<F, S, T, Q> {

    private final F first;
    private final S second;
    private final T third;
    private final Q fourth;

}
