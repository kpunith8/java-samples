package com.java.example.oracle;

public class Circle extends Shape implements SampleInterface {
    @Override
    public void draw() {
	System.out.println("Draw a circle");
    }

    @Override
    public void erase() {
	System.out.println("Erase a circle");
    }

    @Override
    public void area() {
	System.out.println("Area of a circle is: 2*3.141*r*r");
    }
}
