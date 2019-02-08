package com.java.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ComplexMapStream
{
    public static void main(String[] args)
    {
        /*
         * Demonstrates the, searching for a key in a map with list of integers, filtered matching integer list is
         * matched with another list and returns only ones matching the data in each list
         */
        Integer valueToSearch = 20;

        List<Integer> itemsToSearch = new ArrayList<>();
        itemsToSearch.add(10);
        itemsToSearch.add(30);

        Map<Integer, List<Integer>> hashMapWithList = new HashMap<Integer, List<Integer>>();

        hashMapWithList.put(20, new ArrayList<Integer>(Arrays.asList(1, 20, 4, 5, 6)));
        hashMapWithList.put(10, new ArrayList<Integer>(Arrays.asList(8, 20, 11)));
        hashMapWithList.put(30, new ArrayList<Integer>(Arrays.asList(15, 20, 31)));

        Set<Integer> matchingListWithPredicate = hashMapWithList.entrySet().stream()
                .filter(listToLookFor -> listToLookFor.getValue().contains(valueToSearch))
                .map(filteredList -> filteredList.getKey()).collect(Collectors.toSet());

        System.out.println("Filter Predicate: " + matchingListWithPredicate);
        Set<Integer> finalResult = itemsToSearch.stream().filter(a -> matchingListWithPredicate.contains(a))
                .collect(Collectors.toSet());

        System.out.println("Final Filtered Result" + finalResult);
    }
}
