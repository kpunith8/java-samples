package com.java.example.devoxx;

/**
 * <p>
 * Same copy as that of one in JDK 1.8.
 * </p>
 * 
 * @author Punith K
 */
@FunctionalInterface
public interface Predicate<T>
{
    boolean test(T t);

    default Predicate<T> negate()
    {
        return t -> !this.test(t);
    }

    default Predicate<T> and(Predicate<T> other)
    {
        return t -> this.test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate<T> other)
    {
        return t -> this.test(t) || other.test(t);
    }
}
