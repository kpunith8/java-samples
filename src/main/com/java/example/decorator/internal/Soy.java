package main.com.java.example.decorator.internal;

import main.com.java.example.decorator.Beverage;
import main.com.java.example.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator
{
    Beverage beverage;

    public Soy(Beverage beverage)
    {
        this.beverage = beverage;
    }

    @Override
    public String getDescription()
    {
        return beverage.getDescription() + ", Soy. ";
    }

    @Override
    public double cost()
    {
        return 0.22 + beverage.cost();
    }

}
