package main.com.java.example.main;

public class RegExp
{
    public static void main(String[] a)
    {
        String EXAMPLE_TEST = "Hi this is    Punith , \"Cool!\"";
        String EXAMPLE_TEST_1 = "<title name=\"Punith\"> Hello World </title>";

        String pattern = "(\\w)(\\s+)([\\.,])*";

        // $1 specifies group 1 and $3 specifies group 3
        // It keeps only $1 and $3 group not $2s
        System.out.println(EXAMPLE_TEST.replaceAll(pattern, "$1$3"));

        String pattern1 = "(?i)(<title.*?>)(.+?)(</title>)";
        String updated = EXAMPLE_TEST_1.replaceAll(pattern, "$1");
        System.out.println(updated);

    }
}
