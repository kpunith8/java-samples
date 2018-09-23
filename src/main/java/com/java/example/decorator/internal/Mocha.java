package com.java.example.decorator.internal;

import com.java.example.decorator.Beverage;
import com.java.example.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator
{
    Beverage beverage;

    public Mocha(Beverage beverage)
    {
        this.beverage = beverage;
    }

    @Override
    public String getDescription()
    {
        return beverage.getDescription() + ", Mocha.";
    }

    @Override
    public double cost()
    {
        return 1.2 + beverage.cost();
    }

}
