package test.com.java.example.lamda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;


public class ConsumerTest {
    @Test
    @DisplayName("Test consumer returns empty list")
    public void testConsumerReturnsEmptyList() {
        // Consumer<List<String>> consumer = strs -> strs.clear();
        // Using method references
        Consumer<List<String>> consumer = List::clear;
        List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));

        consumer.accept(list);

        Assertions.assertEquals(list, Collections.emptyList());
    }

    @Test
    @DisplayName("Test consumer calls two consumers")
    public void testConsumerCallsTwoConsumers() {
        Consumer<List<String>> consumer1 = list -> list.add("first");
        Consumer<List<String>> consumer2 = list -> list.add("second");

        Consumer<List<String>> mainConsumer = consumer1.andThen(consumer2);

        List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));

        mainConsumer.accept(list);

        Assertions.assertEquals(list, new ArrayList<String>(Arrays.asList("a", "b", "c", "first", "second")));
    }
}

