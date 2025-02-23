package com.pisa.techtest.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovimientoDTO {

    private String id;
    private Long cuentaId;
    private Date fecha;
    private String tipoMovimiento;
    private double valor;
    private double saldo;
    private String numeroCuenta;

}