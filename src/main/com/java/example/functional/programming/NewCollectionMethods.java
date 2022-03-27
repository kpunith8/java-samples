package main.com.java.example.functional.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.com.java.example.model.City;
import main.com.java.example.model.Gender;
import main.com.java.example.model.Person;

public class NewCollectionMethods
{
    public static List<Person> createPeople()
    {
        return Arrays.asList(new Person("Sara", Gender.FEMALE, 28), new Person("Sara", Gender.FEMALE, 22),
                new Person("Sara", Gender.FEMALE, 20), new Person("Bob", Gender.MALE, 20),
                new Person("Paul", Gender.MALE, 32), new Person("Paula", Gender.FEMALE, 32),
                new Person("Jack", Gender.FEMALE, 2), new Person("Jack", Gender.FEMALE, 70));
    }

    public static void main(String[] args)
    {
        List<Person> people = new ArrayList<>(createPeople());

        City india = new City("India");
        City newYork = new City("New York");

        Map<City, List<Person>> cityPersonMap1 = new HashMap<>();
        Map<City, List<Person>> cityPersonMap2 = new HashMap<>();


        // people.removeIf(person -> person.getAge() < 5);

        // people.replaceAll(person -> new Person(person.getName().toUpperCase(), person.getGender(), person.getAge()));

        // people.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName).reversed());

        // people.forEach(System.out::println);

        // Adding data to map using putIfAbsent
        cityPersonMap1.putIfAbsent(india, new ArrayList<>());

        cityPersonMap1.get(india).add(people.get(0));
        cityPersonMap1.get(india).add(people.get(1));

        // Adding data to map using computeIfAbsent()
        cityPersonMap1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(people.get(2));
        cityPersonMap1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(people.get(3));

        cityPersonMap2.computeIfAbsent(india, city -> new ArrayList<>()).add(people.get(4));
        cityPersonMap2.computeIfAbsent(newYork, city -> new ArrayList<>()).add(people.get(5));

        System.out.println("People from India: " + cityPersonMap1.getOrDefault(india, Collections.emptyList()));
        System.out.println("People from New York: " + cityPersonMap1.getOrDefault(newYork, Collections.emptyList()));

        System.out.println("Merging  cityPersonMap2  with cityPersonMap1");

        cityPersonMap2.forEach((city, peopleC) -> {
            cityPersonMap1.merge(city, peopleC, (peopleFromMap1, peopleFromMap2) -> {
                peopleFromMap1.addAll(peopleFromMap2);

                return peopleFromMap1;
            });
        });

        // cityPersonMap2 is merged with cityPersonMap1
        cityPersonMap1.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
