package com.java.example.functional.programming;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Functional programming examples using lambda and streams
 * </p>
 * 
 * @author Punith K
 */
public class IteratingArray
{
	public static void main(String[] args)
	{
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<String> names = Arrays.asList("Tom", "Jerry", "Jack", "Jose");
		// External iterators
		/*
		 * for (int i = 0; i < numbers.size(); i++) {
		 * System.out.println(numbers.get(i)); } for (int number : numbers) {
		 * System.out.println(number); }
		 */
		// Internal iterators
		// Passing annonymous function to forEach
		/*
		 * numbers.forEach(new Consumer<Integer>() {
		 * @Override public void accept(Integer value) { System.out.println(value);
		 * } });
		 */
		// Using lambda
		// numbers.forEach(value -> System.out.println(value));
		// Using method references
		// numbers.forEach(System.out::println);
		// Find the total of double of even numbers
		// Imperative way
		/*
		 * int result = 0; for (int number : numbers) { if (number % 2 == 0) {
		 * result += number * 2; } } System.out.println(result);
		 */
		// Functional way: Using streams
		// System.out.println(numbers.stream().filter(number -> number % 2 ==
		// 0).mapToInt(number -> number * 2).sum());
		// final int factor = 2;
		/*
		 * Java 8 makes it effectively final if it is referenced from a lambda
		 * expression, it is not allowed to re-assign later
		 */
		// numbers.stream().map(number -> number *
		// factor).forEach(System.out::println);
		// This lambda has to close-over it defining scope looking for variable
		// 'factor' to bind to - Closure
		// Lambdas are stateless
		// Closure has Immutable state
		/*
		 * Method references, works on static methods and instance variables as well
		 */
		// Without using method references
		// numbers.stream().map(number ->
		// String.valueOf(number)).forEach(System.out::println);
		// Using static method reference on String.valueOf() // Since it accepts
		// only parameter
		// numbers.stream().map(String::valueOf).forEach(System.out::println);
		// Using instance method reference on number.toString()
		// numbers.stream().map(number ->
		// String.valueOf(number)).map(String::toString).forEach(System.out::println);
		// Passing multiple parameters to method references, order should be
		// maintained
		// without method references
		// int sumWithoutMethodReferences = numbers.stream().reduce(0, (total,
		// number) -> Integer.sum(total, number));
		// int sumWithMethodReferences = numbers.stream().reduce(0, Integer::sum);
		// System.out.println("Passing multiple params to method references: Where
		// first and second params are
		// arguments"
		// + sumWithMethodReferences);
		// String convertIntToString =
		// numbers.stream().map(String::valueOf).reduce("", String::concat);
		// reduce without method references can be written as; reduce("", (carry,
		// str) -> carry.concat(str))
		// System.out.println(
		// "Passing multiple parameters where first param is target and second param
		// is param (order matters when using
		// method references): "
		// + convertIntToString);
		// Using parallel streams to use the multiple threads
		// Using normal streams
		// TimeIt.code(() -> numbers.stream().filter(number -> number % 2 ==
		// 0).mapToInt(IteratingArray::compute).sum());
		//
		// Using parallel streams
		// TimeIt.code(() -> numbers.parallelStream().filter(number -> number % 2 ==
		// 0).mapToInt(IteratingArray::compute)
		// .sum());
		// List<Integer> doubleOfEven1 = new ArrayList<>();
		// This would mutate the state of the list whenever for each number, which
		// is shared variable outside
		// numbers.stream().filter(number -> number % 2 == 0).map(number -> number *
		// 2)
		// .forEach(number -> doubleOfEven1.add(number));
		// To get rid of mutating the list use collect(toList()) which will return a
		// list once the processing on stream
		// is done,
		// toList() is a static import from java.util.streams.Collectors.*;
		// List<Integer> doubleOfEven = numbers.stream().filter(number -> number % 2
		// == 0).map(number -> number * 2)
		// .collect(toList());
		// To create a map with name and age as key and person object as value
		/*
		 * people.stream.collect(toMap(person -> person.getName() + "-" +
		 * person.getAge(), person -> person));
		 */
		// Create a map where their name is the key and value is all the people with
		// that name.
		/*
		 * people.stream.collect(groupingBy(Person::getName)); // Creates a map by
		 * name
		 */
		// Create a map where their name is the key and value is ages of all the
		// people with that name.
		/*
		 * people.stream.collect(groupingBy(Person::getName, mapping(Person::getAge,
		 * toList())));
		 */
		// A stream can be sized, sorted, ordered, and distinct or vice-versa, apply
		// these methods to make it sorted(),
		// distinct()
		// Stream.iterate(100, e -> e + 1); which will create a infinite numbers
		// starting from 100, but it gives Head
		// with laziness
		// Convert all the names to uppercase separarated by comma
		System.out.println("Convert to uppercase and separate by comma: "
				+ names.stream().map(String::toUpperCase).collect(joining(", ")));
	}

	public static int compute(int number)
	{
		// Assume it as time intensive computations
		try
		{
			Thread.sleep(1000); // Delay by a second to see the improvement in using
													// parallel stream
		}
		catch (Exception e)
		{
		}
		return number * 2;
	}
}
