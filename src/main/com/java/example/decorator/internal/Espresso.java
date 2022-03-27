package main.com.java.example.decorator.internal;

import main.com.java.example.decorator.Beverage;

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
