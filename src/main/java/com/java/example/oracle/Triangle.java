package com.java.example.oracle;

public class Triangle extends Shape implements SampleInterface {

    public void draw() {
	System.out.println("Draw a Triangle");
    }

    @Override
    public void erase() {
	System.out.println("Erase a Triangle");
    }

    @Override
    public void area() {
	System.out.println("Area of a triangle is: h*b/2");
    }
}
