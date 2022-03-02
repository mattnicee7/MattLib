package com.github.mattnicee7.singlemap;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Triple<F, S, T> {

    private final F first;
    private final S second;
    private final T third;

}
