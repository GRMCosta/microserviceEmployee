package com.grcosta.microservice.infra.resource;

import com.grcosta.microservice.domain.Employee;
import com.grcosta.microservice.domain.service.EmployeeService;
import com.grcosta.microservice.infra.resource.data.CreateEmployeeRequest;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class CreateEmployeeResource {

    private final EmployeeService employeeService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@Valid @RequestBody CreateEmployeeRequest request) {
        val employeeCreated = employeeService.createdEmployee(request);
        return employeeCreated;
    }
}
