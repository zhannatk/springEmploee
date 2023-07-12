package com.prosky.course2.employee.springemployee.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNameInvalid extends RuntimeException {
    public EmployeeNameInvalid(String message) {
        super(message);
    }



}
