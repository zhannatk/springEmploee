package com.prosky.course2.employee.springemployee.Controller;

import com.prosky.course2.employee.springemployee.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prosky.course2.employee.springemployee.Employee;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    //http://localhost:8080/employee/add?firstName=Ivan2&lastName=Ivanov
    //http://localhost:8080/employee/add?firstName=Ivan&lastName=Ivanov
    //http://localhost:8080/employee/add?firstName=Petr&lastName=Petrov
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName
    ) {
        return employeeServiceImpl.addEmployee(firstName, lastName);
    }

    // http://localhost:8080/employee/find?firstName=Ivan&lastName=Ivanov
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName
    ) {
        return employeeServiceImpl.findEmployee(firstName, lastName);
    }

    // http://localhost:8080/employee/remove?firstName=Ivan&lastName=Ivanov
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName
    ) {
        return employeeServiceImpl.removeEmployee(firstName, lastName);
    }
    // http://localhost:8080/employee/list

    @GetMapping("/list")
    public List<Employee> getEmployee() {
        return employeeServiceImpl.getEmployeesSet();
    }

}
