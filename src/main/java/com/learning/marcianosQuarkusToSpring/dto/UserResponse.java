package com.learning.marcianosQuarkusToSpring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Long id;

    private String nome;

    private String cpf;

    private String email;
}
