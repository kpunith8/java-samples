package com.java.example.generics;

public class TestGenerics
{
    public static void main(String[] args)
    {
        Pair<String, Integer> pairOne = new OrderedPair<String, Integer>("Punith", 1);
        Pair<String, Integer> pairTwo = new OrderedPair<String, Integer>("Punith", 1);
        Pair<String, String> pairThree = new OrderedPair<String, String>("Punith", "K");

        System.out.println("Pair One(Key, Value): " + pairOne.getKey() + " " + pairOne.getValue());

        System.out.println("Pair Two(Key, Value): " + pairTwo.getKey() + " " + pairTwo.getValue());

        System.out.println("Pair Three(Key, Value): " + pairThree.getKey() + " " + pairThree.getValue());

        System.out.println(CompareUtil.<String, Integer> compare(pairOne, pairTwo));
    }
}
