package com.pisa.techtest.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReporteEstadoCuentaDTO {
    private ClienteDTO cliente;
    private List<CuentaDTO> cuentas;
}