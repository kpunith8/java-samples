package com.java.example.streams;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringStream
{
    public static void main(String[] args)
    {
        String myInfo = "Punith, K, SSE";

        List<String> myName = Stream.of(myInfo.split(",")).map(elem -> new String(elem)).collect(Collectors.toList());

        System.out.println("split a comma separated String into a list of String: " + myName.toString());

        String[] strArray = { "Punith", "K", "SSE" };

        String commaSeparatedString = Arrays.asList(strArray).stream().collect(Collectors.joining(","));

        System.out.println("join a String array into a comma-separated String: " + commaSeparatedString);

        String stringJoinWithPrefix = Arrays.asList(strArray).stream().collect(Collectors.joining(",", "[", "]"));

        System.out.println("join a String array with a prefix: " + stringJoinWithPrefix);

        // the chars() method converts the String into a stream of
        // Integer where each Integer value denotes the ASCII value of each and every Char sequence.
        List<Character> strToChar = myInfo.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
        System.out.println("convert a String to a Character list: " + strToChar);

        // convert a String array to map using split and Collectors.toMap,
        // provided each item in the array contains a key-value entity concatenated by a separator

        String[] stringWithCollan = { "Name: Punith K", "Role: Software Engineer" };
        Map<String, String> mapSeparatedByCollan = Arrays.asList(stringWithCollan).stream().map(str -> str.split(":"))
                .collect(toMap(str -> str[0], str -> str[1]));

        for (Map.Entry<String, String> entry : mapSeparatedByCollan.entrySet())
        {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }
    }
}
