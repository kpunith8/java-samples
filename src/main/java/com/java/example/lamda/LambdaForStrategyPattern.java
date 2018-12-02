package com.java.example.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaForStrategyPattern
{
    // Strategy pattern
    public static int totalValues(List<Integer> values, Predicate<Integer> selector)
    {
        // Imperative
        // int result = 0;
        //
        // for (int e : values)
        // {
        // if (selector.test(e))
        // {
        // result += e;
        // }
        // }

        // declarative
        return values.stream().filter(selector).reduce(0, Integer::sum);
        // Instead of reduce use sum()
        // return values.stream().filter(selector).mapToInt(e -> e).sum();
    }

    // Decorator pattern

    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Sum of all the numbers: " + totalValues(numbers, e -> true));
        // Instead of passing function definition, it can be created in a Util class and can be referenced
        // using method references, for ex: Util::isEven, Util::isOdd
        System.out.println("Sum of all even numbers: " + totalValues(numbers, e -> e % 2 == 0));
        System.out.println("Sum of all odd numbers: " + totalValues(numbers, e -> e % 2 != 0));
    }
}
