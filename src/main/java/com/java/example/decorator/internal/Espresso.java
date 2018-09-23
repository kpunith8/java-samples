package com.java.example.decorator.internal;

import com.java.example.decorator.Beverage;

public class Espresso extends Beverage
{

    public Espresso()
    {
        description = "Espresso";
    }

    @Override
    public double cost()
    {
        return 2.0;
    }

}
