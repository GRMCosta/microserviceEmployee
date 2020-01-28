package com.grcosta.microservice.infra.resource;

import com.grcosta.microservice.domain.Employee;
import com.grcosta.microservice.domain.service.EmployeeService;
import com.grcosta.microservice.infra.resource.data.CreateEmployeeRequest;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
public class CreateEmployeeResource {

    private final EmployeeService employeeService;

    public CreateEmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody CreateEmployeeRequest request) {
        val employeeCreated = employeeService.createdEmployee(request);
        return employeeCreated;
    }
}
