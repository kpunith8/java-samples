package com.java.example.devoxx;

import static java.util.stream.Collectors.toMap;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.LongStream;

import com.java.example.model.DataHelper;
import com.java.example.model.People;

public class MapFilterExample {
	public static void main(String[] args) {
		// map and filter
		DataHelper.getAllNames().stream().filter(word -> word.length() == 6).map(String::toUpperCase)
				.forEach(System.out::println);

		// flatmap example
		// DataHelper.getAllNames().stream().flatMap(str ->
		// DataHelper.expand(str).stream()).forEach(System.out::println);

		// separate words from a sonnet and extract to a list, split each word by a
		// space
		// DataHelper.getSonnet().stream().flatMap(line -> Arrays.stream(line.split("
		// +"))).forEach(System.out::println);

		// reduction example: compute the factorial as BigInteger using streams and
		// reduce
		BigInteger factorialOf21 = LongStream.rangeClosed(1, 21).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,
				BigInteger::multiply);
		System.out.println("Factorial of 21 using function combination: " + factorialOf21);

		// Combine unary operators into one
		IntUnaryOperator operator = combineUnaryOperator(List.of(i -> i + 1, i -> i * 2, i -> i + 3));
		System.out.println("Combine unary operators: " + operator.applyAsInt(5));

		// Predicate to check for a string to be non-null, non-empty and should have
		// more than 5 chars
		List<Predicate<String>> strPredicates = List.of(s -> s != null, s -> !s.isEmpty(), s -> s.length() > 5);

		// Use reduce to get one Predicate
		Predicate<String> strPredicate = strPredicates.stream().reduce(s -> true, Predicate::and);

		System.out.println("Test for empty string: " + strPredicate.test(""));
		System.out.println("Test for null string: " + strPredicate.test(null));
		System.out.println("Test for string with more than 5 chars: " + strPredicate.test("sample-string"));

		Map<String, String> namesMap = DataHelper.getAllNames().stream()
				.collect(toMap(word -> word.substring(0, 1), Function.identity()));

		// System.out.println("map by first char of a name as key:");
		// namesMap.entrySet().stream().forEach(System.out::println);

		// If there is duplicate key encounter while converting to a map, provide
		// third param to the toMap() which is a merge function, which takes a duplicate
		// keys and returns the merged value

		// first argument wins over second and second one is excluded in the map,
		// if line2 selected last one wins over the first one
		// Duplicates are eliminated
		Map<String, String> sonnetMap = DataHelper.getSonnet().stream().collect(toMap(line -> line.substring(0, 1),
				line -> line, (line1, line2) -> line1 + System.lineSeparator() + line2));
		// line -> line can be written as Function.identity

		// System.out.println(
		// "map by first char of each line of a sonnet as a key (remove dupicate keys,
		// dupicates are eliminated):");
		// sonnetMap.entrySet().stream().forEach(System.out::println);
	}

	// function combination, if you want pass multiple predicates to filter the
	// products, for example check for person name, person address and person mail
	// to be present
	public static Predicate<People> combine(List<Predicate<People>> predicates) {
		return predicates.stream().reduce(person -> true, Predicate::and);
	}

	public static IntUnaryOperator combineUnaryOperator(List<IntUnaryOperator> unaryOperators) {
		return unaryOperators.stream().reduce(IntUnaryOperator.identity(), IntUnaryOperator::andThen);
	}
}
