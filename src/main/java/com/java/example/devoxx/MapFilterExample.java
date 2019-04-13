package com.java.example.devoxx;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import com.java.example.model.DataHelper;
import com.java.example.model.People;

public class MapFilterExample {
	public static void main(String[] args) {
		List<String> allNames = DataHelper.getAllNames();
		List<String> sonnet = DataHelper.getSonnet();

		/* map and filter */
		allNames.stream().filter(word -> word.length() == 6).map(String::toUpperCase).forEach(System.out::println);

		/* flatmap example */
		// DataHelper.getAllNames().stream().flatMap(str ->
		// DataHelper.expand(str).stream()).forEach(System.out::println);

		/*
		 * separate words from a sonnet and extract to a list, split each word by a
		 * space
		 */
		// DataHelper.getSonnet().stream().flatMap(line -> Arrays.stream(line.split("
		// +"))).forEach(System.out::println);

		/*
		 * reduction example: compute the factorial as BigInteger using streams and
		 * reduce
		 */
		BigInteger factorialOf21 = LongStream.rangeClosed(1, 21).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,
				BigInteger::multiply);
		System.out.println("Factorial of 21 using function combination: " + factorialOf21);

		/* Combine unary operators into one */
		IntUnaryOperator operator = combineUnaryOperator(List.of(i -> i + 1, i -> i * 2, i -> i + 3));
		System.out.println("Combine unary operators: " + operator.applyAsInt(5));

		/*
		 * Predicate to check for a string to be non-null, non-empty and should have
		 * more than 5 chars
		 */
		List<Predicate<String>> strPredicates = List.of(s -> s != null, s -> !s.isEmpty(), s -> s.length() > 5);

		/* Use reduce to get one Predicate */
		Predicate<String> strPredicate = strPredicates.stream().reduce(s -> true, Predicate::and);

		System.out.println("Test for empty string: " + strPredicate.test(""));
		System.out.println("Test for null string: " + strPredicate.test(null));
		System.out.println("Test for string with more than 5 chars: " + strPredicate.test("sample-string"));

		// Map<String, String> namesMap = allNames.stream()
		// .collect(toMap(word -> word.substring(0, 1), Function.identity()));
		// System.out.println("map by first char of a name as key:");
		// namesMap.entrySet().stream().forEach(System.out::println);

		/*
		 * If there is a duplicate key encounter while converting to a map, provide
		 * third param to the toMap() which is a merge function, which takes a duplicate
		 * keys and returns the merged value
		 */

		/*
		 * first argument wins over second and second one is excluded in the map, if
		 * line2 selected last one wins over the first one Duplicates are eliminated
		 */

		// Map<String, String> sonnetMap = sonnet.stream().collect(toMap(line ->
		// line.substring(0, 1), line -> line,
		// (line1, line2) -> line1 + System.lineSeparator() + line2));
		// line -> line can be written as Function.identity()

		// System.out.println(
		// "map by first char of each line of a sonnet as a key (remove duplicate keys,
		// duplicates are eliminated):");
		// sonnetMap.entrySet().stream().forEach(System.out::println);

		/*
		 * groupingBy() - produces a map - they take a classifier function to transform
		 * each stream element into a key Stream<T> => Map<K, List<V>>
		 */
		Map<Integer, List<String>> groupByLengthOfString = allNames.stream()
				.collect(Collectors.groupingBy(String::length));

		System.out.println("Group the names by length of the name: " + groupByLengthOfString);

		Map<String, List<String>> groupSonnetByFirstChar = sonnet.stream()
				.collect(Collectors.groupingBy(line -> line.substring(0, 1)));

		Map<String, Long> groupSonnetByFirstCharAndLength = sonnet.stream()
				.collect(Collectors.groupingBy(line -> line.substring(0, 1), Collectors.counting()));

		Map<String, List<Integer>> groupSonnetByFirstCharAndLengthOfEachSentence = sonnet.stream().collect(Collectors
				.groupingBy(line -> line.substring(0, 1), Collectors.mapping(String::length, Collectors.toList())));

		Map<String, Set<String>> groupSonnetByFirstCharAndFirstWordOfEachSentence = sonnet.stream()
				.collect(Collectors.groupingBy(line -> line.substring(0, 1),
						Collectors.mapping(line -> line.split(" +")[0], Collectors.toSet())));

		System.out.println("Group the sonnet by first char of the sonnet: " + groupSonnetByFirstChar);
		System.out
				.println("Group the sonnet by first char of the sonnet and length: " + groupSonnetByFirstCharAndLength);
		System.out.println("Group the sonnet by first char of the sonnet and length of each sentence: "
				+ groupSonnetByFirstCharAndLengthOfEachSentence);
		System.out.println("Group the sonnet by first char of the sonnet and first word of each sentence: "
				+ groupSonnetByFirstCharAndFirstWordOfEachSentence);

		/* Generate frequency table of letters */
		Map<String, Long> frequencyTableForEachLatterInTheSonnet = sonnet.stream()
				.flatMap(line -> DataHelper.expand(line).stream()).collect(groupingBy(Function.identity(), counting()));
		frequencyTableForEachLatterInTheSonnet.forEach((letter, count) -> System.out.println(letter + " => " + count));

		/* Find the most frequently occurring word in the sonnet */
		Pattern pattern = Pattern.compile("[ ,':\\-]+");
		Collector<String, ?, Map<String, Long>> groupingByCollector = groupingBy(Function.identity(),
				Collectors.counting());

		Map<String, Long> mapOfWordsWithCount = sonnet.stream().flatMap(pattern::splitAsStream)
				.collect(groupingByCollector);

		System.out.println("Words with count: " + mapOfWordsWithCount);

		Map.Entry<String, Long> mostFrequentWord = mapOfWordsWithCount.entrySet().stream()
				.max(Map.Entry.comparingByValue()).orElseThrow();

		System.out.println("Most frequent word: " + mostFrequentWord);

		/* Get the all most frequent words with the same count */
		// Invert the map by switching Map<Long, List<String>>
		Map<Long, List<String>> mostFrequentWordsMap = mapOfWordsWithCount.entrySet().stream().collect(Collectors
				.groupingBy(Entry<String, Long>::getValue, Collectors.mapping(Entry<String, Long>::getKey, toList())));

		Map.Entry<Long, List<String>> mostFrequentWords = mostFrequentWordsMap.entrySet().stream()
				.max(Map.Entry.comparingByKey()).orElseThrow();

		System.out.println("Most frequent words with the same length: " + mostFrequentWords);

		/* Split into sublists of size N adjacent elements */
		final int numberOfPerson = allNames.size();
		int sizeOfTheGroup = 3;

		List<List<String>> subListOfLength3 = IntStream.range(0, (numberOfPerson + sizeOfTheGroup - 1) / sizeOfTheGroup)
				.mapToObj(i -> allNames.subList(sizeOfTheGroup * i, Math.min(numberOfPerson, sizeOfTheGroup * (i + 1))))
				.collect(toList());

		System.out.println("List of names with list 3: " + subListOfLength3);

		/* Stream over indexes to get the list like [[a, b, c], [b, c, d], [c, d, e]] */
		List<List<String>> subListOfLength3AndZipThrough = IntStream.range(0, numberOfPerson - sizeOfTheGroup + 1)
				.mapToObj(i -> allNames.subList(i, i + sizeOfTheGroup)).collect(toList());

		System.out.println("List of names with list 3 zip through: " + subListOfLength3AndZipThrough);
	}

	/*
	 * function combination, if you want pass multiple predicates to filter the
	 * products, for example check for person name, person address and person mail
	 * to be present
	 */
	public static Predicate<People> combine(List<Predicate<People>> predicates) {
		return predicates.stream().reduce(person -> true, Predicate::and);
	}

	public static IntUnaryOperator combineUnaryOperator(List<IntUnaryOperator> unaryOperators) {
		return unaryOperators.stream().reduce(IntUnaryOperator.identity(), IntUnaryOperator::andThen);
	}
}
