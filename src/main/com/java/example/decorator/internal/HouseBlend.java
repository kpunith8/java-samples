package main.com.java.example.decorator.internal;

import main.com.java.example.decorator.Beverage;

public class HouseBlend extends Beverage
{

    public HouseBlend()
    {
        description = "House Blend Coffee";
    }

    @Override
    public double cost()
    {
        return 1.99;
    }

}
