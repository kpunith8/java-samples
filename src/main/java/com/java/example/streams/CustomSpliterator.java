package com.java.example.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.java.example.model.Person;

public class CustomSpliterator
{
    public static void main(String[] args)
    {
        Path path = Paths.get("C:/project_workspace/files/person.txt");

        // try with resource
        try (Stream<String> lines = Files.lines(path))
        {
            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> personSpliterator = new PersonSpliterator(lineSpliterator);

            Stream<Person> person = StreamSupport.stream(personSpliterator, false);

            person.forEach(System.out::println);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
