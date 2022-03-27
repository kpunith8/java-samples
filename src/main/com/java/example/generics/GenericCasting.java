package main.com.java.example.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericCasting
{
    public static void main(String[] args)
    {
        // Requires casting
        List list = new ArrayList();
        list.add("hello");
        String s = (String) list.get(0);
        System.out.println("Raw String: " + s);

        // When re-written to use generics, the code does not require casting:

        List<String> list1 = new ArrayList<String>();
        list1.add("hello");
        String s1 = list1.get(0); // no cast
        System.out.println("Generic String: " + s1);
    }
}
