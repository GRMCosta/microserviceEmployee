package com.grcosta.microservice.infra.resource.data;

import com.grcosta.microservice.infra.Messages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @NotBlank(message = Messages.DISTRICT_IS_REQUIRED)
    private String district;

    @NotBlank(message = Messages.CITY_IS_REQUIRED)
    private String city;

    @NotBlank(message = Messages.STATE_IS_REQUIRED)
    private String state;

    @NotBlank(message = Messages.POSTAL_CODE_IS_REQUIRED)
    private String postalCode;

    @NotBlank(message = Messages.NUMBER_IS_REQUIRED)
    private String number;

}
