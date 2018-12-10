package com.java.example.parallel.async;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCombine
{
    public static CompletableFuture<Integer> create(int number)
    {
        return CompletableFuture.supplyAsync(() -> number);
    }

    public static CompletableFuture<Integer> incrementByOne(int number)
    {
        return CompletableFuture.supplyAsync(() -> number + 1);
    }

    public static void main(String[] args)
    {
        create(2).thenCombine(create(3), (res1, res2) -> res1 + res2).thenAccept(System.out::println);

        // if we apply thenApply(number -> incrementByOne(number)) it returns CompletableFuture
        // it is more like a flatMap in streams
        create(2).thenCompose(number -> incrementByOne(number)).thenAccept(System.out::println);
    }
}
