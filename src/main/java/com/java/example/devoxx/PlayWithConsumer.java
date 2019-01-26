package com.java.example.devoxx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayWithConsumer
{
    public static void main(String[] args)
    {
        Consumer<List<String>> consumer1 = list -> list.add("one");
        Consumer<List<String>> consumer2 = list -> list.add("two");

        Consumer<List<String>> consumer = consumer1.andThen(consumer2);

        List<String> list = new ArrayList<String>(Arrays.asList("zero"));

        consumer.accept(list);

        System.out.println(list);
    }
}


