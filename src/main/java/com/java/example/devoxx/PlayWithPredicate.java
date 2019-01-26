package com.java.example.devoxx;

public class PlayWithPredicate
{
    public static void main(String[] args)
    {
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        Predicate<String> nonNull = s -> s != null;

        Predicate<String> predicateAnd = nonNull.and(isEmpty.negate());

        // NPE can be prevented by using Objects.requireNonNull(obj) in the API
        // Predicate<String> predicateAndNullOther = nonNull.and(null);
        // predicateAndNullOther.test("test");

        System.out.println("and() method on predicate: " + predicateAnd.test("p"));

        Predicate<String> predicateOr = nonNull.or(isEmpty);
        System.out.println("or() method on predicate: " + predicateOr.test(""));

        System.out.println("With value: " + isNotEmpty.test("Punith"));
        System.out.println("With empty string: " + isNotEmpty.test(""));

        Predicate<String> p1 = s -> s.length() == 4;
        Predicate<String> p2 = s -> s.startsWith("J");

        Predicate<String> predicateXor = p1.XOR(p2);

        System.out.println("Predicates to test XOR: length=4 and starts with J");
        System.out.println("XOR: test(True): " + predicateXor.test("True"));
        System.out.println("XOR: test(Julia): " + predicateXor.test("Julia"));
        System.out.println("XOR: test(Java): " + predicateXor.test("Java"));
    }
}
