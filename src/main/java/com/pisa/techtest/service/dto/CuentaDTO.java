package com.pisa.techtest.service.dto;

import com.pisa.techtest.domain.enumeration.TipoCuenta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CuentaDTO {

    private Long id;
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private double saldoInicial;
    private boolean estado;

    private Long clienteId;

    private List<MovimientoDTO> movimientos;


}