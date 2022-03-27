package main.com.java.example.lamda;

import java.util.function.Consumer;

public class LambdaForExecuteAroundPattern
{
    public static void main(String[] args)
    {
        Resource.use(resource -> resource.operation1().operation12());
    }
}

class Resource
{
    private Resource()
    {
        System.out.println("Resource created");
    }

    public Resource operation1()
    {
        System.out.println("Operation 1");
        return this;
    }

    public Resource operation12()
    {
        System.out.println("Operation 2");
        return this;
    }

    private static void close()
    {
        System.out.println("Closing the resources");
    }

    public static void use(Consumer<Resource> block)
    {
        // Params to the constructor can be passed as additional params in use
        // method
        Resource resource = new Resource();
        try
        {
            block.accept(resource);
        }
        finally
        {
            Resource.close();
        }
    }
}