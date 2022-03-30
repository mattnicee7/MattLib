package com.github.mattnicee7.mattlib.singlemap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Quintuple<F, S, T, Q, E> {

    private F first;
    private S second;
    private T third;
    private Q fourth;
    private E fifth;

    public static<F, S, T, Q, E> Quintuple<F, S, T, Q, E> of(F first, S second, T third, Q fourth, E fifth) {
        return new Quintuple<>(first, second, third, fourth, fifth);
    }

}
