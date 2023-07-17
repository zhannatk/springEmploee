package com.prosky.course2.employee.springemployee.service;

import com.prosky.course2.employee.springemployee.models.Employee;

import java.util.List;

public interface EmployeeService {


    Employee removeEmployee(String firstName, String lastName);

    List<Employee> employeeList();

    Employee addEmployee(String firstName, String lastName, int salary, int department);

    Employee findEmployee(String firstName, String lastName);
    List<Employee> getEmployeesList();

 void validation(String fn, String ln);
}
