package main.com.java.example.devoxx;

import java.util.List;

import main.com.java.example.model.People;
import main.com.java.example.model.Person;

public class PlayWithComparator
{
    public static void main(String[] args)
    {
        List<Person> people = People.createPeople();
        
        // Comparator<Person> cmp = (p1, p2) -> p1.getName().compareTo(p2.getName());

        // System.out.println(people);

        Comparator<Person> cmp1 = Comparator.comparing(p -> p.getName());
        
        java.util.Comparator<Person> cmp = java.util.Comparator.comparing(p -> p.getName());
        people.stream().sorted(cmp).forEach(System.out::println);

    }
}
