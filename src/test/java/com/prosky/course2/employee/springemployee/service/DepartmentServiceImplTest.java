package com.prosky.course2.employee.springemployee.service;

import com.prosky.course2.employee.springemployee.Exceptions.EmployeeNotFoundException;
import com.prosky.course2.employee.springemployee.models.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static com.prosky.course2.employee.springemployee.service.EmpSvcImplConstants.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    List<Employee> tempMockEmpList = new ArrayList<>();
    @Mock
    private EmployeeService empSvc;
    @InjectMocks
    private DepartmentServiceImpl depSvc;



/*    EmployeeServiceImpl empSvc =new EmployeeServiceImpl();
    DepartmentServiceImpl depSvc = new DepartmentServiceImpl(empSvc);*/
    @BeforeEach
    void prepareBook() {
        assertNotNull(empSvc);
        tempMockEmpList.add(new Employee(FIRST_NAME_1, SECOND_NAME_1, SALARY_200, DEPARTMENT_1));
        tempMockEmpList.add(new Employee(FIRST_NAME_2, SECOND_NAME_2, SALARY_300, DEPARTMENT_2));
        tempMockEmpList.add(new Employee(FIRST_NAME_3, SECOND_NAME_3, SALARY_500, DEPARTMENT_1));
        tempMockEmpList.add(new Employee(FIRST_NAME_4, SECOND_NAME_4, SALARY_200, DEPARTMENT_2));
    }

    @Test
    void shouldPrintEmpWithMinSalaryInFirstDepartment() {
        Mockito.when(empSvc.employeeList()).thenReturn(tempMockEmpList);


        Employee tmp = depSvc.printEmpWithMinSalaryInDepartment(DEPARTMENT_1);
        assertEquals(new Employee(FIRST_NAME_1, SECOND_NAME_1, SALARY_200, DEPARTMENT_1), tmp);
    }

    @Test
    void shouldTrowEscNoFoundEmpFromMinSalaryInGhostDepartment() {
        Mockito.when(empSvc.employeeList()).thenReturn(tempMockEmpList);
        assertThrows(EmployeeNotFoundException.class, () ->
                depSvc.printEmpWithMinSalaryInDepartment(DEPARTMENT_GHOST));
    }


    @Test
    void shouldPrintEmpWithMaxSalaryInSecondDepartment() {
        Mockito.when(empSvc.employeeList()).thenReturn(tempMockEmpList);
        Employee tmp = depSvc.printEmpWithMinSalaryInDepartment(DEPARTMENT_2);
        assertEquals(new Employee(FIRST_NAME_4, SECOND_NAME_4, SALARY_200, DEPARTMENT_2), tmp);

    }

    @Test
    void shouldTrowEscNoFoundEmpFromMaxSalaryInGhostDepartment() {
        Mockito.when(empSvc.employeeList()).thenReturn(tempMockEmpList);
        assertThrows(EmployeeNotFoundException.class, () ->
                depSvc.printEmpWithMinSalaryInDepartment(DEPARTMENT_GHOST));
    }
    @Test
    void printAllEmployeesOfDep() {
        Mockito.when(empSvc.employeeList()).thenReturn(tempMockEmpList);
        List<Employee> tmpDep2 = tempMockEmpList.stream()
                .filter(employee -> employee.getDepartment() == 2)
                .collect(Collectors.toList());

        assertEquals(tmpDep2, depSvc.printAllEmployeesOfDep(DEPARTMENT_2));
    }

    @Test
    void printAllEmployeesByDep() {
        Mockito.when(empSvc.employeeList()).thenReturn(tempMockEmpList);
        Map<Integer, List<Employee>> tmpMap = depSvc.printAllEmployeesByDep();
        List<Employee> expectDep1 = List.of(new Employee(FIRST_NAME_1, SECOND_NAME_1, SALARY_200, DEPARTMENT_1),
                new Employee(FIRST_NAME_3, SECOND_NAME_3, SALARY_500, DEPARTMENT_1));

        List<Employee> expectDep2 = List.of(new Employee(FIRST_NAME_2, SECOND_NAME_2, SALARY_300, DEPARTMENT_2),
                new Employee(FIRST_NAME_4, SECOND_NAME_4, SALARY_200, DEPARTMENT_2));

        assertTrue(expectDep1.containsAll(tmpMap.get(DEPARTMENT_1)) &&
                expectDep2.containsAll(tmpMap.get(DEPARTMENT_2)));
    }
}