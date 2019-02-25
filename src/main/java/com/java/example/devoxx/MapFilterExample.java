package com.java.example.devoxx;

import java.math.BigInteger;
import java.util.List;
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
		System.out.println("Factorial of 21 is: " + factorialOf21);
	}

	// function combination, if you want pass multiple predicates to filter the
	// products
	public static Predicate<People> combine(List<Predicate<People>> predicates) {
		// Using streams
		return predicates.stream().reduce(person -> true, Predicate::and);
//		Predicate<People> temp = person -> true;
//
//		for (Predicate<People> curPredicate : predicates) {
//			temp = temp.and(curPredicate);
//		}
//
//		return temp;
	}
}
