package main.com.java.example.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * <p>
 * Consists of statistics examples using streams, parallel streams, and collectors
 * </p>
 * 
 * @author Punith K
 */
public class StreamStatistics
{
    public static void main(String[] args) throws IOException
    {
        // https://introcs.cs.princeton.edu/java/data/words.shakespeare.txt
        // https://introcs.cs.princeton.edu/java/data/ospd.txt

        Set<String> shakespeareWords = Files.lines(Paths.get("src/main/resources/files/words-shakespeare.txt"))
                .map(String::toLowerCase).collect(Collectors.toSet());

        Set<String> scrabbleWords = Files.lines(Paths.get("src/main/resources/files/scrabble-words.txt"))
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

        /* Parallel Streams */

        // Stream<Long> longStream = Stream.generate(() -> ThreadLocalRandom.current().nextLong());
        //
        // Stream<Long> longStream1 = ThreadLocalRandom.current().longs(10000000).mapToObj(Long::new);
        //
        // System.out.println("Normal Execution:");
        // TimeIt.code(() -> longStream.limit(10000000).collect(Collectors.toList()));
        //
        // System.out.println("Parallel execution:");
        // TimeIt.code(() -> longStream1.parallel().collect(Collectors.toList()));

        // Handling the thread pool for parallelism
        // System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");

        // Stream.iterate("+", s -> s + "+").parallel().limit(6)
        // .peek(s -> System.out.println(s + " Processed in the thread: " + Thread.currentThread().getName()))
        // .forEach(s -> {
        // });

        /* Concurrent issue in parallel stream */

        // It could end up in an ArrayOutOfBoundOfException because ArrayList is not thread safe
        // List<String> strings = new ArrayList<>();

        // use CopyOnWriteArrayList to avoid these problems, don't use this is in production
        /// List<String> strings1 = new CopyOnWriteArrayList<>();

        // Stream.iterate("+", s -> s + "+").parallel().limit(10000).forEach(e -> strings1.add(e));

        // System.out.println("# of strings: " + strings1.size());

        // Instead of adding elements in forEach to the collection use Collectors.toList()
        // which is thread safe
        
        // List<String> str = Stream.iterate("+", s -> s + "+").parallel().limit(10000).collect(Collectors.toList());
        //
        // System.out.println("# of strings: " + str.size());

        /*
         * Collectors example
         */
        Map<Integer, List<String>> histoWordsByScore = shakespeareWords.stream()
                .collect(Collectors.groupingBy(score));
        // System.out.println(histoWordsByScore);

        System.out.println("# of histo words: " + histoWordsByScore.size());

        histoWordsByScore.entrySet().stream().sorted(Comparator.comparing(entry -> -entry.getKey())).limit(3)
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}
