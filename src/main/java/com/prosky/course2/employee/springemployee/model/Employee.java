package com.prosky.course2.employee.springemployee.model;

import java.util.Objects;

public class Employee {

    private final String firstName;

    private final String lastName;


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

    public Employee(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;

    }


    public String getLastName() {
        return this.lastName;

    }

    public String getFirstName() {
        return this.firstName;

    }

    @Override
    public String toString() {
        return "lastname: " + lastName +
                ", firstName: " + firstName;
    }



}
