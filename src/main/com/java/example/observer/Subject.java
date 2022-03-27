package main.com.java.example.observer;

public interface Subject
{
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
