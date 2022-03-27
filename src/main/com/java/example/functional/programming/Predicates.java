package main.com.java.example.functional.programming;

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
		
        UserDefinedPredicate<String> isGT5 = str -> str.length() > 5;
        UserDefinedPredicate<String> isLT10 = str -> str.length() < 10;
        
        UserDefinedPredicate<String> andPredicate = isGT5.and(isLT10);
        System.out.println("Using user defined predicate (default method): " + andPredicate.test("Punith"));

        UserDefinedPredicate<String> staticPredicate = UserDefinedPredicate.isEqualTo("Yes");
        System.out.println("Using user defined predicate (static method): " + staticPredicate.test("Yes"));


		print(10, isEven, "is even?");
		print(3, isGT6, "is greater than 6?");

		// Checking for both isEven and isGT6, using predicate
		print(12, isGT6.and(isEven), "is greater than 6 and even?");
	}
}

@FunctionalInterface
interface UserDefinedPredicate<T>
{
    boolean test(T t);

    default UserDefinedPredicate<T> and(UserDefinedPredicate<T> other)
    {
        return t -> test(t) && other.test(t);
    }

    // Creating a static method
    static <U> UserDefinedPredicate<U> isEqualTo(U u)
    {
        return s -> s.equals(u);
    }
}
