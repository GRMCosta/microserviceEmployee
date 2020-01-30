package com.grcosta.microservice.infra.resource.data;

import com.grcosta.microservice.domain.Address;
import com.grcosta.microservice.domain.Employee;
import com.grcosta.microservice.infra.Messages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    @NotBlank(message = Messages.NAME_IS_REQUIRED)
    private String name;

    @NotBlank(message = Messages.CONTACT_IS_REQUIRED)
    private String contact;

    @NotBlank(message = Messages.EMAIL_IS_REQUIRED)
    private String email;

    @Valid
    @NotNull(message = Messages.ADDRESS_IS_REQUIRED)
    private AddressRequest address;

    @NotBlank(message = Messages.SALARY_IS_REQUIRED)
    private String salary;

    @NotBlank(message = Messages.BOSS_IS_REQUIRED)
    private String boss;

    public Employee toEmployee(){
        return Employee.builder()
                .name(name)
                .contact(contact)
                .email(email)
                .address(Address.builder()
                        .district(address.getDistrict())
                        .city(address.getCity())
                        .state(address.getState())
                        .postalCode(address.getPostalCode())
                        .number(address.getNumber())
                        .build())
                .createdDateTime(LocalDate.now())
                .salary(salary)
                .boss(boss)
                .build();
    }
}
