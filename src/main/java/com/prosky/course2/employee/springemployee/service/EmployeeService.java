package com.prosky.course2.employee.springemployee.service;

import com.prosky.course2.employee.springemployee.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
    Collection<Employee> getEmployeesSet();
}
