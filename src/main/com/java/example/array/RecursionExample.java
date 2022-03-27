package main.com.java.example.array;

public class RecursionExample
{
    public static void main(String[] args)
    {
        System.out.println("Multiply(5,6):" + multiply(5, 6));
        System.out.println("Factorial(6): " + factorial(5));
        System.out.println("gcd=" + gcd(45, 54));
    }

    public static int multiply(int a, int b)
    {
        if (b == 1)
        {
            return a;
        }
        return a + multiply(a, b - 1);
    }

    public static int factorial(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int gcd(int p, int q)
    {
        if (q == 0)
            return p;
            return gcd(q, p % q);
    }

}
