package com.java.example.observer.internal;

import java.util.ArrayList;

import com.java.example.observer.Observer;
import com.java.example.observer.Subject;

public class WeatherData implements Subject
{
    private float temperature;
    private float humidity;
    private float pressure;
    private ArrayList<Observer> observers;

    public WeatherData()
    {
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer observer)
    {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer)
    {
        int i = observers.indexOf(observer);

        if (i >= 0)
        {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver()
    {
        for (int i = 0; i < observers.size(); i++)
        {
            Observer observer = observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged()
    {
        notifyObserver();
    }

    public void setMeasurements(float temperature, float humidity, float pressure)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature()
    {
        return temperature;
    }

    public float getHumidity()
    {
        return humidity;
    }

    public float getPressure()
    {
        return pressure;
    }
}
