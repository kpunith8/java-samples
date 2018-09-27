package com.java.example.functional.programming;

// Four rules of default methods:
// 1. You get what is in the base interface; here SeaPlane gets the Fly's
// takeOff() default method
// 2. You can override a default method
// 3. If a method is there in the class hierarchy then, it takes the precedence
// 4. If there is no method on any of the classes in the hierarchy, but two of
// your interfaces that you implements has the default method
interface Fly
{
	default void takeOff()
	{
		System.out.println("Fly::Take Off");
	}
}

interface FastFly extends Fly
{
	/**
	 * 2nd Rule:
	 * 
	 * Overriding the base interface's default method, Overriden default method
	 * takes the precedence over base's default method.
	 */
	default void takeOff()
	{
		System.out.println("FastFly::Take Off");
	}
}

interface Sail
{
	default void takeOff()
	{
		System.out.println("Sail::Take Off");
	}
}

class SeaPlane extends Vehicle implements FastFly, Sail
{
	/**
	 * 4th rule:
	 * 
	 * Both Sail and FastFly interfaces have the same method, it won't use method
	 * of either of the classes, compiler complains to override the method either
	 * from Sail or FastFly
	 */
	public void takeOff()
	{
		System.out.println("SeaPlane::Take Off");
		/**
		 * To access the base interface's default method, To make sure it uses
		 * implementation of FastFly, reduces boilerplate.
		 * 
		 * {@code super} keyword is look for a default method from that interface,
		 * or it looks for the static method in the interface
		 */
		FastFly.super.takeOff();
	}
}

class Vehicle
{
	/**
	 * 3rd Rule:
	 * 
	 * This method takes the precedence over Fly's default method since it has the
	 * same name and return type as that of Fly's default method.
	 */
	public void takeOff()
	{
		System.out.println("Vehicle::Take Off");
	}
}

/**
 * <p>
 * The default methods examples.
 * </p>
 * 
 * @author Punith K
 */
public class DefaultMethods
{
	public void use()
	{
		SeaPlane seaPlane = new SeaPlane();
		seaPlane.takeOff();
	}

	public static void main(String[] args)
	{
		System.out.println("Number of cores: " + Util.numberOfCores());
		new DefaultMethods().use();
	}
}

/**
 * Static methods in interface
 */
interface Util
{
	static int numberOfCores()
	{
		return Runtime.getRuntime().availableProcessors();
	}
}