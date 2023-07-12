package com.prosky.course2.employee.springemployee.models;

import com.prosky.course2.employee.springemployee.Exceptions.EmployeeNotFoundException;
import com.prosky.course2.employee.springemployee.Exceptions.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmployeeBook {

    private final int MAX_QUANTITY;
    private final Map<String, Employee> employeeMap = new HashMap<>();

    public EmployeeBook(int maxQuantity) {
        MAX_QUANTITY = maxQuantity;
    }

    private String makeKey(String fn, String ln) {
        return fn + " " + ln;
    }

    public Employee addEmployee(String firstName, String lastName,int salary, int department) {
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);


        if (employeeMap.size() >= MAX_QUANTITY)
            throw new EmployeeStorageIsFullException("Storage is maximum " + MAX_QUANTITY + " employees");
        if (employeeMap.containsKey(makeKey(firstName, lastName)))
            throw new EmployeeNotFoundException("Такой сотрудник уже имеется");
        Employee employee = new Employee(firstName, lastName, salary,  department);
        employeeMap.put(makeKey(firstName, lastName), employee);
        return employee;
    }




    public Employee findEmployee(String firstName, String lastName) {
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);

        Employee employee = employeeMap.get(makeKey(firstName, lastName));
        if (employee == null)
            throw new EmployeeNotFoundException("Сотрудник не найден");
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);

        Employee employee = employeeMap.remove(makeKey(firstName, lastName));
        if (employee == null)
            throw new EmployeeNotFoundException("Сотрудник не найден");
        return employee;
    }

    public List<Employee> printEmployeeMap() {
        return new ArrayList<>(employeeMap.values());

    }

}
