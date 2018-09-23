package com.java.example.observer.internal;

import com.java.example.observer.DisplayElement;
import com.java.example.observer.Observer;
import com.java.example.observer.Subject;

public class StatisticsDisplay implements DisplayElement, Observer
{
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject subject;

    public StatisticsDisplay(Subject subject)
    {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display()
    {
        System.out.println("Statistics Display: " + temperature + "F degrees, " + humidity + "% humidity, and "
                + pressure + " pressure");
    }
}