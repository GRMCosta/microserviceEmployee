package com.grcosta.microservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employees")
public class Employee {

    @Id
    private String id;

    private String name;

    private String contact;

    private String email;

    private String cpf;

    private Address address;

    private LocalDate createdDateTime;

    private String salary;

    private String boss;




}
