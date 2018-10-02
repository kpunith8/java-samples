package com.java.example.model;

import java.util.Arrays;
import java.util.List;

public class People
{
    public static List<Person> createPeople()
    {
        return Arrays.asList(new Person("Sara", Gender.FEMALE, 28), new Person("Sara", Gender.FEMALE, 22),
                new Person("Sara", Gender.FEMALE, 20), new Person("Bob", Gender.MALE, 20),
                new Person("Paul", Gender.MALE, 32), new Person("Paula", Gender.FEMALE, 32),
                new Person("Jack", Gender.FEMALE, 2), new Person("Jack", Gender.FEMALE, 70));
    }
}
