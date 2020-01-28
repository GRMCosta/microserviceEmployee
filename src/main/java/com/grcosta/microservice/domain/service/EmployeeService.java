package com.grcosta.microservice.domain.service;

import com.grcosta.microservice.domain.Employee;
import com.grcosta.microservice.domain.repository.EmployeeRepository;
import com.grcosta.microservice.infra.resource.data.CreateEmployeeRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createdEmployee(CreateEmployeeRequest request){
        log.info("Inicializing Employee creation");
        val employee = request.toEmployee();
        employeeRepository.save(employee);
        log.info("Finalizing employee creation");
        return employee;
    }
}
