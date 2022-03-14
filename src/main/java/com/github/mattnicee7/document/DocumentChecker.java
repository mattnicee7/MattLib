package com.github.mattnicee7.document;

import org.jetbrains.annotations.NotNull;

public interface DocumentChecker<T> {

    boolean check(@NotNull T t);

}
