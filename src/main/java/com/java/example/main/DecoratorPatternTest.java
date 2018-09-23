package com.java.example.main;

import com.java.example.decorator.Beverage;
import com.java.example.decorator.internal.Espresso;
import com.java.example.decorator.internal.HouseBlend;
import com.java.example.decorator.internal.Mocha;
import com.java.example.decorator.internal.Soy;

public class DecoratorPatternTest
{
    public static void main(String[] args)
    {
        // Espresso with no condiments
        Beverage beverage1 = new Espresso();

        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        // Espresso wrapped with double Mocha
        Beverage beverage2 = new Espresso();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);

        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        // Espresso wrapped with mocha and soy
        Beverage beverage3 = new HouseBlend();
        beverage3 = new Mocha(beverage3);
        beverage3 = new Soy(beverage3);

        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
