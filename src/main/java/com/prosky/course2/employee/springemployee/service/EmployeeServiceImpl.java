package com.prosky.course2.employee.springemployee.service;

import com.prosky.course2.employee.springemployee.Employee;
import com.prosky.course2.employee.springemployee.Exceptions.EmployeeAlreadyAddedException;
import com.prosky.course2.employee.springemployee.Exceptions.EmployeeNotFoundException;
import com.prosky.course2.employee.springemployee.Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public final int MAX_QUANTITY = 2;
    private final Set<Employee> employeesSet = new HashSet<>();


    @Override
    public Employee addEmployee(String firstName, String lastName) {

        if (employeesSet.size() >= MAX_QUANTITY) {
            throw new EmployeeStorageIsFullException("Storage is maximum " + MAX_QUANTITY + " employees");
        }

        Employee tmpEmp = new Employee(firstName, lastName);

        if (!employeesSet.add(tmpEmp)) {
            throw new EmployeeAlreadyAddedException("Employee is already exist");
        }
        return tmpEmp;
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee tmpEmp = new Employee(firstName, lastName);

        if (employeesSet.contains(tmpEmp))
            return tmpEmp;

        throw new EmployeeNotFoundException("Employee is not found");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee tmpEmp = new Employee(firstName, lastName);

        if (employeesSet.remove(tmpEmp))
            return tmpEmp;

        throw new EmployeeNotFoundException("Employee is not found");
    }

    @Override
    public List<Employee> getEmployeesSet() {
        return new ArrayList<>(employeesSet);
    }


}
