package com.java.example.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Objects;
import java.util.function.Predicate;

import org.junit.Test;

public class PredicateTest
{
    @Test
    public void testPredicate_string_empty_nonEmpty()
    {
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        
        assertThat(isNotEmpty.test(""), is(false));
        assertThat(isNotEmpty.test("Punith"), is(true));

        assertThat(isEmpty.test("Punith"), is(false));
        assertThat(isEmpty.test(""), is(true));
    }

    @Test
    public void testPredicate_string_nonNull_andNonEmpty()
    {
        Predicate<String> nonNull = Objects::nonNull;
        Predicate<String> isEmpty = String::isEmpty;

        Predicate<String> predicate = nonNull.and(isEmpty.negate());

        assertThat(predicate.test("Punith"), is(true));
        assertThat(predicate.test(null), is(false));
        assertThat(predicate.test(""), is(false));
    }

    @Test
    public void testPredicate_xOr_Operation()
    {
        Predicate<String> p1 = s -> s.length() == 4;
        Predicate<String> p2 = s -> s.startsWith("J");

        Predicate<String> predicate = p1.negate().or(p2.negate());

        assertThat(predicate.test("True"), is(true));
        assertThat(predicate.test("Julia"), is(true));
        assertThat(predicate.test("Java"), is(false));
    }
}
