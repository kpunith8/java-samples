package main.com.java.example.main;

public class SingletonPattern
{
    // private static SingletonPattern instance = new SingletonPattern();
    //
    // private SingletonPattern()
    // {
    // }

    /* Lazy Loading */
    private static SingletonPattern instance = null;

    public static SingletonPattern getInstance()
    {
        if (instance == null)
        {
            instance = new SingletonPattern();
        }

        return instance;
    }

    // public static SingletonPattern getInstance()
    // {
    // return instance;
    // }
}
