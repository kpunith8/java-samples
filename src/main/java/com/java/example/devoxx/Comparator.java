package com.java.example.devoxx;

import java.util.Objects;
import java.util.function.Function;

/**
 * <p>
 * Same as that of one in JDK.
 * </p>
 * 
 * @author Punith K
 */
@FunctionalInterface
public interface Comparator<T>
{
    int compare(T t1, T t2);
    
    default <U extends Comparable<? super U>> Comparator<T> thenComparing(Function<T, U> keyExtracter)
    {
        Objects.requireNonNull(keyExtracter);

        return (t1, t2) -> {
            int cmp = this.compare(t1, t2);
            if (cmp == 0)
            {
                Comparator<T> other = comparing(keyExtracter);
                return other.compare(t1, t2);
            }
            return cmp;
        };
    }

    static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<T, U> keyExtracter)
    {
        Objects.requireNonNull(keyExtracter);

        return (t1, t2) -> {
            U k1 = keyExtracter.apply(t1);
            U k2 = keyExtracter.apply(t2);

            return k1.compareTo(k2);
        };
    }
}
