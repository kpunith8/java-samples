package com.java.example.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
        // Generate streams
        // Stream.generate(() -> "element").limit(10).forEach(System.out::println);

        // Primitive Streams
        IntStream intStream = IntStream.range(1, 10); // rangeClosed
        // intStream.filter(x -> x % 2 == 0).forEach(System.out::println);


        // Initialise with new ArrayList(createPeople()), it won't allow removing
        // action on Arrays.asList()
        List<Person> people = People.createPeople();

        System.out.println("Average Age: " + people.stream().collect(Collectors.averagingDouble(Person::getAge)));

        // Summarizing, it has getCount(), getSum(), getMin(), getAverage(), and getMax()
        System.out.println("Summarizing Age: " + people.stream().collect(Collectors.summarizingDouble(Person::getAge)));

        // Partition the stream based on a predicate
        System.out.println(
                "Group ages: "
                        + people.stream().collect(Collectors.partitioningBy(person -> person.getAge() > 30)));

        // Group the stream based on a predicate
        System.out.println("Partition ages: "
                + people.stream().collect(Collectors.groupingBy(Person::getAge)));

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

        // Compare by age, followed by name
		// printSorted(people,
		// comparing(Person::getAge).thenComparing(Person::getName));

        // Reversing the order
		// printSorted(people,
		// comparing(Person::getAge).thenComparing(Person::getName).reversed());
		// Grouping people based on their age, name
        // System.out.println(people.stream().collect(
        // groupingBy(Person::getAge, mapping(Person::getName, toList()))));

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1).map(element -> element.substring(0, 3)).sorted().count();
        
        // Lazy invocation
        Stream<String> stream = list.stream().filter(element -> {
            System.out.println("filter called");
            return element.contains("2");
        }).map(element -> {
            System.out.println("map called");
            return element.toUpperCase();
        });

        // System.out.println(stream.findFirst().get());

        // get an array of Strings and only select even indexed elements

        String[] names = { "Afrim", "Bashkim", "Besim", "Lulzim", "Durim", "Shpetim" };

        List<Person> evenIndexedNames = IntStream.range(0, people.size()).filter(i -> i % 2 == 0)
                .mapToObj(i -> people.get(i)).collect(Collectors.toList());

        System.out.println("selected even indexed elements:" + evenIndexedNames);

        /**
         * Converting Iterable to Stream. The Iterable interface is designed keeping generality in mind and does not
         * provide any stream() method on its own. Pass Iterable to {@Link StreamSupport.stream()} method and get a
         * Stream from the given Iterable instance.
         */
        Iterable<String> stringIterable = Arrays.asList("Testing", "Iterable", "conversion", "to", "Stream");

        // set second parameter to true to enable parallelism
        List<String> iterableToStream = StreamSupport.stream(stringIterable.spliterator(), false)
                .map(String::toUpperCase).collect(Collectors.toList());

        System.out.println("Converting Iterable to streams: " + iterableToStream);
	}
}
