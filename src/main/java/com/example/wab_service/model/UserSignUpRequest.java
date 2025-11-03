package com.example.wab_service.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserSignUpRequest {

    private String email;

    private String password;

    private String name;

    private String birthDate;

    private String gender;

    private String address;

    private String phoneNumber;
}
