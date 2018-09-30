package com.java.example.effectivejava;

public class OperationEnumTest
{
	public static void main(String[] args)
	{
		System.out.println("Before Java 8: " + Operation.DIVIDE.apply(10, 5));
        System.out.println("After Java 8: " + OperationUsingLambda.PLUS.apply(10, 5));
	}
}

