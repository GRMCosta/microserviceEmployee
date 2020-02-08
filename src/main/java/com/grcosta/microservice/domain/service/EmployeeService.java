package com.grcosta.microservice.domain.service;

import com.grcosta.microservice.domain.Employee;
import com.grcosta.microservice.domain.repository.EmployeeRepository;
import com.grcosta.microservice.infra.Messages;
import com.grcosta.microservice.infra.exception.EmployeeException;
import com.grcosta.microservice.infra.resource.data.CreateEmployeeRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee createdEmployee(CreateEmployeeRequest request) {
        log.info("Finding employee");
        val existingEmployee = employeeRepository.findByCpf(request.getCpf());
        existingEmployee.ifPresent(existed -> {
            log.error("Employee already exists");
            throw new EmployeeException(Messages.EMPLOYEE_ALREADY_EXISTS);
        });
        log.info("Initializing Employee creation");
        val employee = request.toEmployee();
        employeeRepository.save(employee);
        log.info("Finalizing employee creation");
        return employee;
    }
}
