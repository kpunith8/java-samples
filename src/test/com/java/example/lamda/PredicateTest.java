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

        Assertions.assertEquals(isNotEmpty.test(""), false);
        Assertions.assertEquals(isEmpty.test("Punith"), false);
        Assertions.assertEquals(isEmpty.test(""), true);
    }

    @Test
    @DisplayName("Test Predicate String non null and non empty")
    public void testPredicateStringNonNullAndNonEmpty() {
        Predicate<String> nonNull = Objects::nonNull;
        Predicate<String> isEmpty = String::isEmpty;

        Predicate<String> predicate = nonNull.and(isEmpty.negate());

        Assertions.assertEquals(predicate.test("Punith"), true);
        Assertions.assertEquals(predicate.test(null), false);
        Assertions.assertEquals(predicate.test(""), false);
    }

    @Test
    @DisplayName("Test Predicate XOR Operation")
    public void testPredicateXOROperation() {
        Predicate<String> p1 = s -> s.length() == 4;
        Predicate<String> p2 = s -> s.startsWith("J");

        Predicate<String> predicate = p1.negate().or(p2.negate());

        Assertions.assertEquals(predicate.test("True"), true);
        Assertions.assertEquals(predicate.test("Julia"), true);
        Assertions.assertEquals(predicate.test("Java"), false);
    }
}
