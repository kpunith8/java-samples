package com.java.example.devoxx;

public class PlayWithPredicate
{
    public static void main(String[] args)
    {
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        Predicate<String> nonNull = s -> s != null;

        Predicate<String> predicateAnd = nonNull.and(isEmpty.negate());
        System.out.println("and() method on predicate: " + predicateAnd.test("p"));

        Predicate<String> predicateOr = nonNull.or(isEmpty);
        System.out.println("or() method on predicate: " + predicateOr.test(""));

        System.out.println("With value: " + isNotEmpty.test("Punith"));
        System.out.println("With empty string: " + isNotEmpty.test(""));
    }
}
