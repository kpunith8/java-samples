package com.java.example.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

public class ConsumerTest
{
    @Test
    public void testConsumer_returnsEmptyList()
    {
        // Consumer<List<String>> consumer = strs -> strs.clear();
        // Using method references
        Consumer<List<String>> consumer = List::clear;
        List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));

        consumer.accept(list);

        assertThat(list, is(Collections.emptyList()));
    }

    @Test
    public void testConsumer_callsTwoConsumer()
    {
        Consumer<List<String>> consumer1 = list -> list.add("first");
        Consumer<List<String>> consumer2 = list -> list.add("second");

        Consumer<List<String>> mainConsumer = consumer1.andThen(consumer2);

        List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));

        mainConsumer.accept(list);

        assertThat(list, is(new ArrayList<String>(Arrays.asList("a", "b", "c", "first", "second"))));
    }
}
