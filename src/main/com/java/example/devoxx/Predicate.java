package main.com.java.example.devoxx;

import java.util.Objects;

/**
 * <p>
 * Same as that of one in JDK 1.8.
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
        // Checks for non-null
        Objects.requireNonNull(other, "Operations cannot be done on null reference");
        return t -> this.test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate<T> other)
    {
        // Checks for non-null
        Objects.requireNonNull(other, "Operations cannot be done on null reference");
        return t -> this.test(t) || other.test(t);
    }

    /*
     * This method does not exist in JDK, user defined one
     */
    default Predicate<T> XOR(Predicate<T> other)
    {
        // Checks for non-null
        Objects.requireNonNull(other, "Operations cannot be done on null reference");

        // use ^ symbol instead of || and don't use negate on this and other
        // return t -> this.test(t) ^ other.test(t);

        return t -> this.negate().test(t) || other.negate().test(t);
    }
}
