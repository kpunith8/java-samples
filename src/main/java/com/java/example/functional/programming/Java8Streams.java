package com.java.example.functional.programming;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8Streams
{
	public static List<Person> createPeople()
	{
		return Arrays.asList(new Person("Sara", Gender.FEMALE, 20),
				new Person("Sara", Gender.FEMALE, 22),
				new Person("Sara", Gender.FEMALE, 20),
				new Person("Bob", Gender.MALE, 20), new Person("Paul", Gender.MALE, 32),
				new Person("Paula", Gender.FEMALE, 32),
				new Person("Jack", Gender.FEMALE, 2),
				new Person("Jack", Gender.FEMALE, 70));
	}

	public static void printSorted(List<Person> people,
			Comparator<Person> comparator)
	{
		people.stream().sorted(comparator)
				.forEach(System.out::println);
	}

	public static void main(String[] args)
	{
		List<Person> people = createPeople();

		// printSorted(people, comparing(Person::getName));
		// printSorted(people, comparing(Person::getAge));
		printSorted(people,
				comparing(Person::getAge).thenComparing(Person::getName));
	}
}
