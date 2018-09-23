package com.java.functional.examples;

import java.util.Arrays;
import java.util.List;

public class IteratingArray
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // External iterators
        /*
         * for (int i = 0; i < numbers.size(); i++) { System.out.println(numbers.get(i)); }
         * 
         * for (int number : numbers) { System.out.println(number); }
         */

        // Internal iterators

        // Passing annonymous function to forEach
        /*
         * numbers.forEach(new Consumer<Integer>() {
         * 
         * @Override public void accept(Integer value) { System.out.println(value); } });
         */

        // Using lambda
        // numbers.forEach(value -> System.out.println(value));

        // Using method references
        // numbers.forEach(System.out::println);

        // Find the total of double of even numbers
        // Imperative way
        /*
         * int result = 0; for (int number : numbers) { if (number % 2 == 0) { result += number * 2; } }
         * 
         * System.out.println(result);
         */

        // Functional way: Using streams
        System.out.println(numbers.stream().filter(number -> number % 2 == 0).mapToInt(number -> number * 2).sum());

        final int factor = 2;
        /*
         * Java 8 makes it effectively final if it is referenced from a lambda expression, it is not allowed to
         * re-assign later
         */
        numbers.stream().map(number -> number * factor).forEach(System.out::println);

        // This lambda has to close-over it defining scope looking for variable 'factor' to bind to - Closure
        // Lambdas are stateless
        // Closure has Immutable state
    }
}
