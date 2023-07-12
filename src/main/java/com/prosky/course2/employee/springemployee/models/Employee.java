package com.prosky.course2.employee.springemployee.models;

import java.util.Objects;

public class Employee {

    private final String firstName;

    private final String lastName;

    private  int salary;

    private int department;
    public Employee(String firstName, String lastName, int salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }




    public String getLastName() {
        return this.lastName;

    }

    public String getFirstName() {
        return this.firstName;

    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "lastname: " + lastName +
                ", firstName: " + firstName;
    }



}
