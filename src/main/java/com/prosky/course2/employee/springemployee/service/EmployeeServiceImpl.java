package com.prosky.course2.employee.springemployee.service;

import com.prosky.course2.employee.springemployee.model.Employee;
import com.prosky.course2.employee.springemployee.model.EmployeeBook;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeBook employeeBook = new EmployeeBook(2);


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        return employeeBook.addEmployee(firstName, lastName);
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return employeeBook.findEmployee(firstName, lastName);
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        return employeeBook.removeEmployee(firstName, lastName);
    }

    @Override
    public List<Employee> getEmployeesSet() {
        return employeeBook.printEmployeeMap();
    }


}
