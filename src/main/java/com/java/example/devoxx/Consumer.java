package com.java.example.devoxx;

/**
 * <p>
 * Same as that of one in JDK 1.8.
 * </p>
 * 
 * @author Punith K
 */
@FunctionalInterface
public interface Consumer<T>
{
    void accept(T t);

    default Consumer<T> andThen(Consumer<T> other)
    {
        return t -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
