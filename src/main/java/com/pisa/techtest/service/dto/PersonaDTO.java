package com.pisa.techtest.service.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDTO {
    private String identificacion;
    private String nombre;
    private String genero;
    private int edad;
    private String direccion;
    private String telefono;
}