package com.prosky.course2.employee.springemployee.service;

import com.prosky.course2.employee.springemployee.models.Employee;

import java.util.Collection;

public interface EmployeeService {


    Employee removeEmployee(String firstName, String lastName);

    Employee addEmployee(String firstName, String lastName, int salary, int department);

    Employee findEmployee(String firstName, String lastName);
    Collection<Employee> getEmployeesSet();

 void validation(String fn, String ln);
}
