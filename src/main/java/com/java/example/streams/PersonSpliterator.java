package com.java.example.streams;

import java.util.Locale;
import java.util.Spliterator;
import java.util.function.Consumer;

import com.java.example.model.Gender;
import com.java.example.model.Person;

public class PersonSpliterator implements Spliterator<Person>
{
    private final Spliterator<String> lineSpliterator;
    private String name;
    private String gender;
    private int age;

    public PersonSpliterator(Spliterator<String> lineSpliterator)
    {
        this.lineSpliterator = lineSpliterator;
    }

    @Override
    public int characteristics()
    {
        return lineSpliterator.characteristics();
        // Spliterator.ORDERED, Spliterator.SIZED, Spliterator.SUBSIZED;
    }

    @Override
    public long estimateSize()
    {
        return lineSpliterator.estimateSize() / 3;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Person> action)
    {
        if (this.lineSpliterator.tryAdvance(line -> this.name = line)
                && this.lineSpliterator.tryAdvance(line -> this.gender = line)
                && this.lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line)))
        {
            Person person = new Person(name, Gender.valueOf(gender.toUpperCase(Locale.ENGLISH)), age);
            action.accept(person);

            return true;
        }

        return false;
    }

    @Override
    public Spliterator<Person> trySplit()
    {
        // Can be used if we are processing the stream in parallel
        return null;
    }
}
