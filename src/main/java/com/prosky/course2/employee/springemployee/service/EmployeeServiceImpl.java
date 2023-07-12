package com.prosky.course2.employee.springemployee.service;

import com.prosky.course2.employee.springemployee.Exceptions.EmployeeNameInvalid;
import com.prosky.course2.employee.springemployee.models.Employee;
import com.prosky.course2.employee.springemployee.models.EmployeeBook;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeBook employeeBook = new EmployeeBook(4);


    public List<Employee> employeeList(){
        return employeeBook.printEmployeeMap();
    }


    @Override
    public Employee addEmployee(String firstName, String lastName,int salary, int department) {
        validation(firstName,lastName);
        return employeeBook.addEmployee(firstName, lastName, salary,  department);
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        validation(firstName,lastName);
        return employeeBook.findEmployee(firstName, lastName);
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        validation(firstName,lastName);
        return employeeBook.removeEmployee(firstName, lastName);
    }

    @Override
    public List<Employee> getEmployeesSet() {
        return employeeBook.printEmployeeMap();
    }

    @Override
    public void validation(String fn, String ln) {
        if (!StringUtils.isAlpha(fn) || !StringUtils.isAlpha(ln)) throw new EmployeeNameInvalid("ФИО должно быть из букофф");
    }


}
