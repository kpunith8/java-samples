package com.java.oracle.examples;

public class InheritanceDemo {

    public static void main(String[] args) {
	/**
	 * There are times when you must add new interface elements to a derived
	 * type, thus extending the interface. The new type can still be
	 * substituted for the base type, but the substitution isn’t perfect
	 * because your "new methods are not accessible from the base type".
	 * This can be described as an islike-a relationship.
	 */

	/**
	 * Substitute an object of the derived class for an object of the base
	 * class. This can be thought of as 'pure substitution', and it’s often
	 * referred to as the 'substitution principle'.
	 */

	Circle circleShape = new Circle();
	circleShape.setColor("Blue");


	Triangle triangleShape = new Triangle();
	triangleShape.setColor("Red");

	doSomething(circleShape);
	circleShape.area();
	System.out.println("Color of the circle is: " + circleShape.getColor());

	System.out.println();

	doSomething(triangleShape);
	triangleShape.area();
	System.out.println("Color of the triangle is: "
		+ triangleShape.getColor());
    }

    public static void doSomething(Shape shape) {
	shape.draw();
	shape.erase();
    }
}
