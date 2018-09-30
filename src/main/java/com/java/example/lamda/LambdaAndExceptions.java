package com.java.example.lamda;

//Throw an exception from a lambda expression.
interface DoubleNumericArrayFunc
{
    double func(double[] n) throws EmptyArrayException;
}

class EmptyArrayException extends Exception
{
    private static final long serialVersionUID = -233607494479557742L;

    EmptyArrayException()
    {
        super("Empty array not allowed");
    }
}

class LambdaAndExceptions
{
    public static void main(String args[]) throws EmptyArrayException
    {
        double[] values = { 1.0, 2.0, 3.0, 4.0 };

        // This block lambda computes the average of an array of doubles.
        DoubleNumericArrayFunc average = (n) -> { // Type is inferred from the context, no need to pass it as n[]
            double sum = 0;
            if (n.length == 0)
                throw new EmptyArrayException();
            for (int i = 0; i < n.length; i++)
                sum += n[i];
            return sum / n.length;
        };
        System.out.println("The average is " + average.func(values));

        // This causes an exception to be thrown.
        System.out.println("The average is " + average.func(new double[0]));
    }
}
