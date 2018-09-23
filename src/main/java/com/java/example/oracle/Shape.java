package com.java.example.oracle;

public class Shape {
    private String color;
    
    public void draw()
    {
	System.out.println("Draw a shape");
    }
    
    public void setColor(String color) {
	this.color = color;
    }

    public void erase() {
	System.out.println("Erase a shape");
    }

    public String getColor() {
	return color;
    }
}
