package com.java.example.functional.programming;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;

import com.java.example.model.People;
import com.java.example.model.Person;

// 1. Streams does not hold any data; it pulls the data it processes from a source
// 2. Stream does not modify the data it processes
// 3. Source may be unbounded; not finite and size of the source is not known at built time.
public class StreamExample
{
	public static void printSorted(List<Person> people,
			Comparator<Person> comparator)
	{
		people.stream().sorted(comparator)
				.forEach(System.out::println);
	}

	public static void main(String[] args)
	{
        // Initialise with new ArrayList(createPeople()), it won't allow removing
        // action on Arrays.asList()
        List<Person> people = People.createPeople();

        // people.add(new Person("Sara", Gender.FEMALE, 28));
        // people.add(new Person("Jack", Gender.FEMALE, 2));
        //
        // System.out.println("Before Removing collection size: " + people.size());
        //
        // people.removeIf(person -> person.getAge() < 5);
        //
        // System.out.println("After Removing collection size: " + people.size());

		// Compare by name
		// printSorted(people, comparing(Person::getName));
		
		// Compare by age
		// printSorted(people, comparing(Person::getAge));

		// Compare by age, followed bby name
		// printSorted(people,
		// comparing(Person::getAge).thenComparing(Person::getName));

        // Reversing the order
		// printSorted(people,
		// comparing(Person::getAge).thenComparing(Person::getName).reversed());

		// Grouping people based on their age, name
		System.out.println(people.stream().collect(
				groupingBy(Person::getAge, mapping(Person::getName, toList()))));

	}
}
