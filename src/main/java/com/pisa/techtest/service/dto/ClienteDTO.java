package com.pisa.techtest.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO extends PersonaDTO {
    private Long id;
    private boolean estado;
    private String contraseña;

}
