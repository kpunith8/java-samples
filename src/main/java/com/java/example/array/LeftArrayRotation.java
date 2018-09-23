package com.java.example.array;

import java.util.Scanner;

public class LeftArrayRotation
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++)
        {
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for (int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();
    }

    public static int[] arrayLeftRotation(int[] a, int n, int k)
    {
        int[] temp = new int[k + (n - k)];

        for (int i = k; i < n; i++)
        {
            temp[i] = a[n - 1];
        }

        return temp;
    }
}
