package com.java.example.functional.programming;

import java.util.HashMap;
import java.util.Map;

public class MapFunctions
{
    public static double compute(int number)
    {
        return Math.sqrt(number);
    }

    public static void main(String[] args)
    {
        Map<Integer, Double> sqrt = new HashMap<>();
        // Imperative
        // if (!sqrt.containsKey(2)) sqrt.put(2, compute(2));
        // if (!sqrt.containsKey(4)) sqrt.put(4, compute(4));

        // Declarative way
        sqrt.computeIfAbsent(2, MapFunctions::compute);
        sqrt.computeIfAbsent(2, MapFunctions::compute);
        System.out.println(sqrt.get(2));
    }
}
