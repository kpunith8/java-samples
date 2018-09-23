package com.java.example.main;

import com.java.example.observer.internal.CurrentConditionsDisplay;
import com.java.example.observer.internal.ForecastDisplay;
import com.java.example.observer.internal.StatisticsDisplay;
import com.java.example.observer.internal.WeatherData;

public class ObserverPatternTest
{
    public static void main(String[] args)
    {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(78, 60, 28.4f);
        // weatherData.setMeasurements(87, 78, 32.5f);
        System.out.println("-------------------------------------------------");
        weatherData.setMeasurements(23, 90, 98.4f);
    }
}
