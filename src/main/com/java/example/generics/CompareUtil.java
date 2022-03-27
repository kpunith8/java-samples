package main.com.java.example.generics;

/**
 * @author Punith K
 */
public class CompareUtil {
    // The syntax for a generic method includes a type parameter, inside angle
    // brackets, and appears before the method's return type.
    // For static generic methods, the type parameter section must appear before
    // the method's return type.
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
	return p1.getKey().equals(p2.getKey())
		&& p1.getValue().equals(p2.getValue());
    }
}
