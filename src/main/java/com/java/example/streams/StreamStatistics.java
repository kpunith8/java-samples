package com.java.example.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class StreamStatistics
{
    public static void main(String[] args) throws IOException
    {
        // https://introcs.cs.princeton.edu/java/data/words.shakespeare.txt
        // https://introcs.cs.princeton.edu/java/data/ospd.txt

        Set<String> shakespeareWords = Files.lines(Paths.get("C:/project_workspace/files/words-shakespeare.txt"))
                .map(String::toLowerCase).collect(Collectors.toSet());

        Set<String> scrabbleWords = Files.lines(Paths.get("C:/project_workspace/files/scrabble-words.txt"))
                .map(String::toLowerCase).collect(Collectors.toSet());

        System.out.println("# words in shakespeare: " + shakespeareWords.size());
        System.out.println("# words in scrabble: " + scrabbleWords.size());

        // Give each char a rank/score to determine the best word
        final int[] scrabbleENScore = { 1, 2, 5, 4, 2, 1, 1, 5, 8, 9, 10, 2, 3, 2, 3, 1, 2, 2, 2, 5, 7, 4, 7, 5, 8,
                10 };

        Function<String, Integer> score = word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();

        ToIntFunction<String> intScore = word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();

        System.out.println("Score of hello: " + intScore.applyAsInt("hello"));

        String bestWord = shakespeareWords.stream().filter(scrabbleWords::contains).max(Comparator.comparing(score))
                .get();

        System.out.println("Best word: " + bestWord);

        IntSummaryStatistics summaryStatistics = shakespeareWords.stream().filter(scrabbleWords::contains)
                .mapToInt(intScore).summaryStatistics();

        System.out.println("Stats: " + summaryStatistics);
    }
}
