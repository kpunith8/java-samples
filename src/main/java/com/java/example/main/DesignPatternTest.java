package com.java.example.main;

import com.java.example.abstractfactory.Computer;
import com.java.example.abstractfactory.ComputerFactory;
import com.java.example.abstractfactory.PCFactory;
import com.java.example.abstractfactory.ServerFactory;

/**
 * <p>
 * Abstract factory test class.
 * </p>
 * 
 * @author Punith K
 */
public class DesignPatternTest
{
    public static void main(String[] args)
    {
        testAbstractFactory();
    }

    private static void testAbstractFactory()
    {
        Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));

        System.out.println("AbstractFactory PC Config: " + pc.getCPU());
        System.out.println("AbstractFactory Server Config: " + server.getHDD());
    }
}
