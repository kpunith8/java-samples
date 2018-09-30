package com.java.example.lamda;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T>
{
    int compare(T t1, T t2);

    public static <U> Comparator<U> comparing(Function<U, Comparable<U>> function)
    {
        return (p1, p2) -> function.apply(p1).compareTo((U) function.apply(p2));
    }
}
