package com.prosky.course2.employee.springemployee.service;

import com.prosky.course2.employee.springemployee.models.Employee;

import java.util.List;
import java.util.Map;

public interface DepSvc {
    //вывести чела с максимальной зарплатой по отделу
    Employee printEmpWithMinSalaryInDepartment(int   depID);

    //вывести чела с минимальной зарплатой по отделу
    Employee printEmpWithMaxSalaryInDepartment(int   depID);
    //вывести список сотрудников из какоего-то  отдела
    List <Employee> printAllEmployeesOfDep(int depID);
    //вывести всех по отделам
    Map<Integer,List<Employee>> printAllEmployeesByDep();





}
