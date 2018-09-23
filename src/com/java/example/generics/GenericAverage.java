package com.java.example.generics;

public class GenericAverage
{

    public static void main(String[] args)
    {
        Double doubleNums[] = { 1.0, 2.0, 3.0, 4.0 };
        Long longNums[] = { 1l, 2l, 3l, 4l, 5l };

        Stats<Double> doubleStats = new Stats<Double>(doubleNums);
        Stats<Long> longStats = new Stats<>(longNums);

        double doubleAvg = doubleStats.average();
        double longAvg = longStats.average();

        System.out.println("Average of doubles is: " + doubleAvg);
        System.out.println("Average of doubles is: " + longAvg);
    }

    static class Stats<T extends Number>
    {
        // nums is an array of type T
        // Pass the constructor a reference to
        // an array of type T.
        T[] nums;

        Stats(T[] object)
        {
            nums = object;
        }

        // Return type double in all cases.
        double average()
        {
            double sum = 0.0;
            for (int i = 0; i < nums.length; i++)
            {
                sum += nums[i].doubleValue();
            }

            return sum / nums.length;
        }
    }
}
