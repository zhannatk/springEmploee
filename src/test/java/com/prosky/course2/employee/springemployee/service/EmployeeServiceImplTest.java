package com.prosky.course2.employee.springemployee.service;

import com.prosky.course2.employee.springemployee.Exceptions.EmployeeAlreadyAddedException;
import com.prosky.course2.employee.springemployee.Exceptions.EmployeeNotFoundException;
import com.prosky.course2.employee.springemployee.models.Employee;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static com.prosky.course2.employee.springemployee.service.EmpSvcImplConstants.*;

class EmployeeServiceImplTest {
    Employee testEmp = new Employee("ivan", "ivanov", 200, 2);
    EmployeeService employeeService = new EmployeeServiceImpl();

    private static Stream<Arguments> empProviderForAdd() {
        return Stream.of(
                Arguments.of(FIRST_NAME_1, SECOND_NAME_1, SALARY_200, DEPARTMENT_1),
                Arguments.of(FIRST_NAME_2, SECOND_NAME_2, SALARY_200, DEPARTMENT_2),
                Arguments.of(FIRST_NAME_1_FROM_SMALL, SECOND_NAME_2, SALARY_200, DEPARTMENT_2)

        );
    }

    @ParameterizedTest
    @MethodSource("empProviderForAdd")
    void shouldAddEmployee(String fn, String ln, int salary, int dep) {
        employeeService.addEmployee(fn, ln, salary, dep);
        Employee empTmp = employeeService.findEmployee(fn,ln);
        assertEquals(new Employee(StringUtils.capitalize(fn),StringUtils.capitalize(ln),salary,dep),empTmp);


    }

    @Test
    void shouldThrowExcWhenAlreadyExists(){
        employeeService.addEmployee(FIRST_NAME_1,SECOND_NAME_1,SALARY_200,DEPARTMENT_1);
        assertThrows(EmployeeAlreadyAddedException.class,()->
                employeeService.addEmployee(FIRST_NAME_1,SECOND_NAME_1,SALARY_200,DEPARTMENT_1));
    }

    @Test
    void shouldFindEmployee() {
        employeeService.addEmployee(FIRST_NAME_1,SECOND_NAME_1,SALARY_200,DEPARTMENT_1);
        assertEquals(new Employee(FIRST_NAME_1,SECOND_NAME_1,SALARY_200,DEPARTMENT_1),
                employeeService.findEmployee(FIRST_NAME_1,SECOND_NAME_1));
    }

    @Test
    void shouldRemoveEmployee() {
        employeeService.addEmployee(FIRST_NAME_1,SECOND_NAME_1,SALARY_200,DEPARTMENT_1);
        assertEquals(new Employee(FIRST_NAME_1,SECOND_NAME_1,SALARY_200,DEPARTMENT_1),
                employeeService.removeEmployee(FIRST_NAME_1,SECOND_NAME_1));
    }

    @Test
    void shouldRemoveStranger() {
        employeeService.addEmployee(FIRST_NAME_1,SECOND_NAME_1,SALARY_200,DEPARTMENT_1);
        assertThrows(EmployeeNotFoundException.class,()->
                employeeService.removeEmployee(FIRST_NAME_2,SECOND_NAME_1));
    }
}