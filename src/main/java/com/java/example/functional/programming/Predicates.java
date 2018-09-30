package com.java.example.functional.programming;

import java.util.function.Predicate;

public class Predicates
{
	public static void print(int number, Predicate<Integer> predicate,
			String message)
	{
		System.out.println(number + " " + message + " " + predicate.test(number));
	}

	public static void main(String[] args)
	{
		Predicate<Integer> isEven = number -> number % 2 == 0;
		Predicate<Integer> isGT6 = number -> number > 6;
		
		print(10, isEven, "is even?");
		print(3, isGT6, "is greater than 6?");

		// Checking for both isEven and isGT6, using predicate
		print(12, isGT6.and(isEven), "is greater than 6 and even?");
	}
}
