package com.prosky.course2.employee.springemployee.Controller;

import com.prosky.course2.employee.springemployee.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prosky.course2.employee.springemployee.models.Employee;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    //http://localhost:8080/employee/add?firstName=Ivan2&lastName=Ivanov&salary=100&department=1
    //http://localhost:8080/employee/add?firstName=Ivan&lastName=Ivanov&salary=200&department=2
    //http://localhost:8080/employee/add?firstName=Petr&lastName=Petrov&salary=300&department=3
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") int salary,
                                @RequestParam("department") int department
    ) {
        return employeeServiceImpl.addEmployee(firstName, lastName,salary,department);
    }

    // http://localhost:8080/employee/find?firstName=Ivan&lastName=Ivanov

    //&salary=100&department=1
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
    // http://localhost:8080/employee/printAll

    @GetMapping("/printAll")
    public List<Employee> getEmployee() {
        return employeeServiceImpl.getEmployeesSet();
    }

}
