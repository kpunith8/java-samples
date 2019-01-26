package com.java.example.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * Flat map
 * </p>
 * 
 * @author Punith K
 */
public class flatMapExample
{
    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get("src/main/resources//files/person.txt");
        Path path1 = Paths.get("src/main/resources/files/person1.txt");

        Stream<String> stream1 = Files.lines(path);
        Stream<String> stream2 = Files.lines(path1);


        Stream<Stream<String>> streamOfStreams = Stream.of(stream1, stream2);
        // System.out.println("No. of streams: " + streamOfStreams.count());

        Stream<String> streamOfLines = streamOfStreams.flatMap(Function.identity());
        // System.out.println("No. of lines: " + streamOfLines.count());

        Function<String, Stream<String>> lineSpilter = line -> Pattern.compile(" ").splitAsStream(line);
        
        Stream<String> streamOfWords = streamOfLines.flatMap(lineSpilter).filter(word -> word.length() > 3).distinct()
                .map(String::toLowerCase);
        System.out.println("distinct words lowercased: " + streamOfWords.collect(Collectors.toList()));

    }
}
