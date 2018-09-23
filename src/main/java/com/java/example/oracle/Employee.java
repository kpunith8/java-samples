package com.java.example.oracle;

import java.util.Comparator;

public class Employee
{
    private String name;
    private int age;
    private String designation;

    public Employee(String name, int age, String designation)
    {
        super();
        this.name = name;
        this.age = age;
        this.designation = designation;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getDesignation()
    {
        return designation;
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
    }

    public static Comparator<Employee> nameComparator = new Comparator<Employee>()
    {
        @Override
        public int compare(Employee o1, Employee o2)
        {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Employee> ageComparator = new Comparator<Employee>()
    {
        @Override
        public int compare(Employee o1, Employee o2)
        {
            return o1.getAge() - o2.getAge();
        }
    };
}
