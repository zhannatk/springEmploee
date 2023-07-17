package com.prosky.course2.employee.springemployee.Controller;

import com.prosky.course2.employee.springemployee.models.Employee;
import com.prosky.course2.employee.springemployee.service.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    //    1. Возвращать сотрудника с максимальной зарплатой на основе номера отдела, который приходит в запрос из браузера.
//    /departments/max-salary?departmentId=5
    @GetMapping("/max-salary")
    public Employee printEmpWithMaxSalaryInDepartment(@RequestParam(name = "departmentId") int depI) {
return departmentService.printEmpWithMaxSalaryInDepartment(depI);
    }
//            2.  Возвращать сотрудника с минимальной зарплатой на основе номера отдела.
//     /departments/min-salary?departmentId=5   //вывести чела с минимальной зарплатой по отделу


    @GetMapping("/min-salary")
    public Employee printEmpWithMinSalaryInDepartment(@RequestParam(name = "departmentId") int depID) {
        return departmentService.printEmpWithMinSalaryInDepartment(depID);
    }

    //вывести список сотрудников из какоего-то  отдела
//            3. Возвращать всех сотрудников по отделу.
//    /departments/all?departmentId=5
    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> printAllEmployeesOfDep(@RequestParam(name = "departmentId") int depID) {
        return departmentService.printAllEmployeesOfDep(depID);
    }

    //вывести всех по отделам


    //            4. Возвращать всех сотрудников с разделением по отделам.
//     /departments/all
    @GetMapping("/all")
    Map<Integer, List<Employee>> printAllEmployeesByDep() {
        return departmentService.printAllEmployeesByDep();
    }


}
