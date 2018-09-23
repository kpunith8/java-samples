package com.java.example.decorator.internal;

import com.java.example.decorator.Beverage;

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
