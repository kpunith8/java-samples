package com.java.example.lamda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

interface StringFunc
{
    String func(String s);
}

public class LambdaAndStreams {
    // This method has a functional interface as the type of
    // its first parameter. Thus, it can be passed a reference to
    // any instance of that interface, including the instance created
    // by a lambda expression.
    // The second parameter specifies the string to operate on.
    static String stringOp(StringFunc sf, String s)
    {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambdas add power to Java";
        String outStr;

        System.out.println("Input string: " + inStr);

        // Here, a simple expression lambda that uppercases a string
        // is passed to stringOp( ).
        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("The string in uppercase: " + outStr);

        // This passes a block lambda that removes spaces.
        outStr = stringOp((str) -> {
            String result = "";
            int i;
            for (i = 0; i < str.length(); i++)
                if (str.charAt(i) != ' ')
                    result += str.charAt(i);
            return result;
        }, inStr);

        System.out.println("The string with spaces removed: " + outStr);

        // Of course, it is also possible to pass a StringFunc instance
        // created by an earlier lambda expression. For example,
        // after this declaration executes, reverse refers to an
        // instance of StringFunc.
        StringFunc reverse = (str) -> {
            String result = "";
            int i;
            for (i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);

            return result;
        };

        // Now, reverse can be passed as the first parameter to stringOp()
        // since it refers to a StringFunc object.
        System.out.println("The string reversed: " + stringOp(reverse, inStr));

        // Takes 2 parameters of the type Integer and returns the result of the type Integer
        BinaryOperator<Integer> sum = Integer::sum;
        // Can also be written using lambdas; sum = (i1, i2) -> i1 + i2;

        // Takes String as input and returns String as output
        Function<String, String> convertToUppercase = String::toUpperCase;
        // Can also be written using lambdas; convertToUppercase = str -> str.toUpperCase();
        // can be like Person::getAge

        // Takes String as input and doesn't return anything
        Consumer<String> printAsIs = System.out::println;
        // Can also be written using lambdas; printAsIs = s -> System.out.println(s);

        System.out.println("Sum of two numbers using BinaryOperator: " + sum.apply(100, 200));

        System.out.println("Convert a given string to uppercase using Function: " + convertToUppercase.apply("Punith"));
        
        printAsIs.accept("Punith");
    }
}
