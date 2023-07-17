package com.prosky.course2.employee.springemployee.Controller;

import com.prosky.course2.employee.springemployee.models.Employee;
import com.prosky.course2.employee.springemployee.service.DepSvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentControllerSecond {
    public DepartmentControllerSecond(DepSvc depSvc) {
        this.depSvc = depSvc;
    }

    DepSvc depSvc;

//    GET http://localhost:8080/department/{id}/employees — возвращает список сотрудников по департаменту.

@GetMapping("/{depId}/employees")
public List<Employee> returnAllEmpsOfDep(@PathVariable(name = "depId") int depId){
    return depSvc.printAllEmployeesOfDep(depId);
}

//    GET http://localhost:8080/department/{id}/salary/sum — возвращает сумму зарплат по департаменту.
@GetMapping("/{depId}/salary/sum")
public Integer returnAllSalarySumOfDep(@PathVariable(name = "depId") int depId){
    return depSvc.printSumSalaryInDepartment(depId);
}


//    GET http://localhost:8080/department/{id}/salary/max — возвращает максимальную зарплату по департаменту.
@GetMapping("/{depId}/salary/max")
public Employee printEmpWithMaxSalaryInDepartment(@PathVariable(name = "depId") int depId){
    return depSvc.printEmpWithMaxSalaryInDepartment(depId);
}


//    GET http://localhost:8080/department/{id}/salary/min — возвращает минимальную зарплату по департаменту.
@GetMapping("/{depId}/salary/min")
public Employee printEmpWithMinSalaryInDepartment(@PathVariable(name = "depId") int depId){
    return depSvc.printEmpWithMinSalaryInDepartment(depId);
}


//    GET http://localhost:8080/department/employees — возвращает сотрудников, сгруппированых по отделам в виде Map<Integer,List<Employees>>,
              // где ключ — это номер отдела, а значение — список сотрудников данного отдела.

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> returnAllEmpsByDep(){
        return depSvc.printAllEmployeesByDep();
    }
}
