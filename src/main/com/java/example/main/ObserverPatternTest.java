package main.com.java.example.main;

import main.com.java.example.observer.internal.CurrentConditionsDisplay;
import main.com.java.example.observer.internal.ForecastDisplay;
import main.com.java.example.observer.internal.StatisticsDisplay;
import main.com.java.example.observer.internal.WeatherData;

public class ObserverPatternTest
{
    public static void main(String[] args)
    {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(78, 60, 28.4f);
        weatherData.removeObserver(forecastDisplay);
        // weatherData.setMeasurements(87, 78, 32.5f);
        System.out.println("-------------------------------------------------");
        weatherData.setMeasurements(23, 90, 98.4f);
    }
}
