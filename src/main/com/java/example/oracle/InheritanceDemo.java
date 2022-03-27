package main.com.java.example.oracle;

public class InheritanceDemo {

    public static void main(String[] args) {
	/**
	 * There are times when you must add new interface elements to a derived
	 * type, thus extending the interface. The new type can still be
	 * substituted for the base type, but the substitution is not perfect
	 * because your "new methods are not accessible from the base type".
	 * This can be described as an is like-a relationship.
	 */

	/**
	 * Substitute an object of the derived class for an object of the base
	 * class. This can be thought of as 'pure substitution', and it is often
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
