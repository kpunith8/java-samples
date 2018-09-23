package com.java.example.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regExpression
{
    /*
     * Find the consecutive duplicate words in the sentence and remove them to make a perfect sentence
     */
    public static void main(String[] args)
    {
        String pattern = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*";
        Pattern r = Pattern.compile(pattern, Pattern.MULTILINE + Pattern.CASE_INSENSITIVE);

        System.out.println("Enter the number of statements to be there as input: ");
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        System.out.println("Enter the statement: ");

        while (testCases > 0)
        {
            String input = in.nextLine();
            Matcher m = r.matcher(input);
            boolean findMatch = true;
            while (m.find())
            {
                input = input.replaceAll(m.group(), m.group(1));
                findMatch = false;
            }
            System.out.println(input);
            testCases--;
        }
    }
}
