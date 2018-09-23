package com.java.design.pattern.abstractfactory;

public class ComputerFactory
{
    public static Computer getComputer(ComputerAbstractFactory factory)
    {
        return factory.createComputer();
    }
}
