package com.java.example.functional.programming;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.toCollection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsSample
{
    private static List<String> givenList = Arrays.asList("a", "ab", "ccc", "dd");

    public static void main(String[] args)
    {
        List<String> toList = givenList.stream().collect(Collectors.toList());
        Set<String> toSet = givenList.stream().collect(Collectors.toSet());

        // This will not work with any Immutable collections
        List<String> toCollection = givenList.stream()
                .collect(toCollection(LinkedList::new));
        
        Map<String, Integer> toMap = givenList.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));

        // String joining = givenList.stream().collect(Collectors.joining());
        String joining = givenList.stream().collect(Collectors.joining(" ", "PRE-", "-POST"));

        long counting = givenList.stream().collect(Collectors.counting());

        DoubleSummaryStatistics result = givenList.stream().collect(summarizingDouble(String::length));

        Double averagingDouble = givenList.stream().collect(Collectors.averagingDouble(String::length));

        Double summingDouble = givenList.stream().collect(Collectors.summingDouble(String::length));

        Optional<String> maxBy = givenList.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));

        Map<Integer, Set<String>> groupingBy = givenList.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        
        Map<Boolean, List<String>> partitionBy = givenList.stream()
                .collect(partitioningBy(s -> s.length() > 2));

        System.out.println(partitionBy);
        // it could be getCoount(), getMax(), getMin(), and so on
        // System.out.println("Average: " + result.getAverage());
    }
}
