package com.java.example.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalSample
{
    public static Optional<Double> sqrt(Double d)
    {
        return d > 0d ? Optional.of(Math.sqrt(d)) : Optional.empty();
    }

    public static Optional<Double> inv(Double d)
    {
        return d != 0d ? Optional.of(1d / d) : Optional.empty();
    }

    public static void main(String[] args)
    {
        List<Double> result = new ArrayList<>();

        // Running this in parallel leads to ArrayIndexOutOfBoundException
        // don't use this pattern
        // ThreadLocalRandom.current().doubles(10_000).boxed()
        // .forEach(d -> OptionalSample.sqrt(d).ifPresent(sqrt -> result.add(sqrt)));
        //
        // System.out.println("# of items: " + result.size());

        Function<Double, Stream<Double>> flatMapper = d -> OptionalSample.inv(d)
                .flatMap(OptionalSample::sqrt).map(sqrt -> Stream.of(sqrt))
                .orElseGet(() -> Stream.empty());
        
        result = ThreadLocalRandom.current().doubles(10_000).parallel().boxed().flatMap(flatMapper)
                .collect(Collectors.toList());

        System.out.println("# of items: " + result.size());
    }
}
