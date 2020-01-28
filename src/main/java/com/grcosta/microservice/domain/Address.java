package com.grcosta.microservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String district;

    private String city;

    private String state;

    private String postalCode;

    private String number;


}
