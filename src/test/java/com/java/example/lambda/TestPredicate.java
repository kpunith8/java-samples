package com.java.example.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.function.Predicate;

import org.junit.Test;

public class TestPredicate
{
    @Test
    public void testPredicate_string_empty_nonEmpty()
    {
        Predicate<String> isEmpty = s -> s.isEmpty();
        Predicate<String> isNotEmpty = isEmpty.negate();
        
        assertThat(isNotEmpty.test(""), is(false));
        assertThat(isNotEmpty.test("Punith"), is(true));

        assertThat(isEmpty.test("Punith"), is(false));
        assertThat(isEmpty.test(""), is(true));
    }

    @Test
    public void testPredicate_string_nonNull_orNonEmpty()
    {
        Predicate<String> nonNull = s -> s != null;
        Predicate<String> isEmpty = s -> s.isEmpty();

        Predicate<String> predicate = nonNull.and(isEmpty.negate());

        assertThat(predicate.test("Punith"), is(true));
        assertThat(predicate.test(null), is(false));
        assertThat(predicate.test(""), is(false));
    }
}
