package com.prosky.course2.employee.springemployee.service;

import com.prosky.course2.employee.springemployee.Exceptions.EmployeeNotFoundException;
import com.prosky.course2.employee.springemployee.models.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepSvc{

    EmployeeService empSvcImpl;

    public DepartmentServiceImpl(EmployeeService empSvcImpl) {
        this.empSvcImpl = empSvcImpl;
    }

    @Override
    public Employee printEmpWithMinSalaryInDepartment(int depID) {
        return empSvcImpl.employeeList().stream()
                .filter(employee -> employee.getDepartment()==depID)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException("минимальную зарплату найти нельзя, потому учто все ушли на фронт"));

    }

    @Override
    public Employee printEmpWithMaxSalaryInDepartment(int depID) {

        return empSvcImpl.employeeList().stream()
                .filter(employee -> employee.getDepartment()==depID)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException("максимальную зарплату найти нельзя, потому учто все ушли на фронт"));
    }

    @Override
    public Integer printSumSalaryInDepartment(int depID) {
        return empSvcImpl.employeeList().stream()
                .filter(employee -> employee.getDepartment() == depID)
                .mapToInt(Employee::getSalary)
                .sum();

    }

    @Override
    public List<Employee> printAllEmployeesOfDep(int depID) {
        return  empSvcImpl.employeeList().stream()
                .filter(employee -> employee.getDepartment()==depID)
                .collect(Collectors.toList()) ;

    }

    @Override
    public Map<Integer, List<Employee>> printAllEmployeesByDep() {
        return empSvcImpl.employeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));


    }
}
