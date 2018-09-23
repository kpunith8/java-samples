package com.java.example.oracle;

enum Apple
{
    Blue(10),
    Green(15),
    Red(20),
    Yellow();

    private int price;

    Apple(int price)
    {
        this.price = price;
    }

    int getApplePrice()
    {
        return price;
    }

    // Overloaded constructor - It will be called when no value specified for the enum
    Apple()
    {
        price = -1;
    }
}

public class EnumSample
{
    public static void main(String[] args)
    {
        for (Apple ap : Apple.values())
        {
            System.out.println("Each " + ap + " Costs: " + ap.getApplePrice());
        }
    }
}
