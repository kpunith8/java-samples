package com.java.example.oracle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorSample
{
    public static void main(String[] args)
    {
        List<Employee> employees = new ArrayList<Employee>();
        Employee emp1 = new Employee("Punith", 29, "SSE");
        Employee emp2 = new Employee("Sahana", 25, "SE");
        Employee emp3 = new Employee("Puni", 20, "SSE");
        Employee emp4 = new Employee("Saha Puni", 40, "SSE");

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

        Collections.sort(employees, emp1.ageComparator);

        for (Employee emp : employees)
        {
            System.out.println("Employee age sorted: " + emp.getAge());
        }

        Collections.sort(employees, emp1.nameComparator);

        for (Employee emp : employees)
        {
            System.out.println("Employee name sorted: " + emp.getName());
        }
    }

}
