package com.grcosta.microservice.infra.resource.data;

import com.grcosta.microservice.domain.Address;
import com.grcosta.microservice.domain.Employee;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreateEmployeeRequest {

    private String name;

    private String contact;

    private String email;

    private Address address;

    private String salary;

    private String boss;

    public Employee toEmployee(){
        return Employee.builder()
                .name(name)
                .contact(contact)
                .email(email)
                .address(address)
                .createdDateTime(LocalDate.now())
                .salary(salary)
                .boss(boss)
                .build();
    }
}
