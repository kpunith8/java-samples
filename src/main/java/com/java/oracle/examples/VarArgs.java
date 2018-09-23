package com.java.oracle.examples;

public class VarArgs
{
    public static void main(String[] args)
    {
        System.out.println("Sum of 2 numbers is: " + sumOfManyArgs(23, 45));
        System.out.println("Sum of 3 numbers is: " + sumOfManyArgs(23, 45, 34));
        System.out.println("Sum of 6 numbers is: " + sumOfManyArgs(23, 45, 44, 42, 22, 55));
    }

    private static int sumOfManyArgs(int... values)
    {
        int sum = 0;
        for (int value : values)
        {
            sum += value;
        }
        
        return sum;
    }
}
