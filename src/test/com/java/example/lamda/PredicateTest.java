package test.com.java.example.lamda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateTest {
    @Test
    @DisplayName("Test Predicate String empty or non empty")
    public void testPredicateStringEmptyNonEmpty() {
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        Assertions.assertFalse(isNotEmpty.test(""));
        Assertions.assertFalse(isEmpty.test("Punith"));
        Assertions.assertTrue(isEmpty.test(""));
    }

    @Test
    @DisplayName("Test Predicate String non null and non empty")
    public void testPredicateStringNonNullAndNonEmpty() {
        Predicate<String> nonNull = Objects::nonNull;
        Predicate<String> isEmpty = String::isEmpty;

        Predicate<String> predicate = nonNull.and(isEmpty.negate());

        Assertions.assertTrue(predicate.test("Punith"));
        Assertions.assertFalse(predicate.test(null));
        Assertions.assertFalse(predicate.test(""));
    }

    @Test
    @DisplayName("Test Predicate XOR Operation")
    public void testPredicateXOROperation() {
        Predicate<String> p1 = s -> s.length() == 4;
        Predicate<String> p2 = s -> s.startsWith("J");

        Predicate<String> predicate = p1.negate().or(p2.negate());

        Assertions.assertTrue(predicate.test("True"));
        Assertions.assertTrue(predicate.test("Julia"));
        Assertions.assertFalse(predicate.test("Java"));
    }
}
