package com.pisa.techtest.service.impl;

import com.pisa.techtest.service.ClienteService;
import com.pisa.techtest.service.CuentaService;
import com.pisa.techtest.service.MovimientoService;
import com.pisa.techtest.service.ReporteService;
import com.pisa.techtest.service.dto.ClienteDTO;
import com.pisa.techtest.service.dto.CuentaDTO;
import com.pisa.techtest.service.dto.MovimientoDTO;
import com.pisa.techtest.service.dto.ReporteEstadoCuentaDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final ClienteService clienteService;
    private final CuentaService cuentaService;
    private final MovimientoService movimientoService;

    public ReporteServiceImpl(ClienteService clienteService, CuentaService cuentaService, MovimientoService movimientoService) {
        this.clienteService = clienteService;
        this.cuentaService = cuentaService;
        this.movimientoService = movimientoService;
    }


    public ReporteEstadoCuentaDTO generarReporte(Date fechaInicio, Date fechaFin, Long clienteId) {
        ClienteDTO clienteDTO = clienteService.getClienteById(clienteId);

        List<CuentaDTO> cuentas = cuentaService.getCuentasByClientId(clienteId);

        List<CuentaDTO> cuentasDTO = cuentas.stream().map(cuenta -> {
            List<MovimientoDTO> movimientoDTOS = movimientoService.getMovimientosByCuentaIdAndFechaBetween(fechaInicio, fechaFin, cuenta.getNumeroCuenta());

            cuenta.setMovimientos(movimientoDTOS);
            return cuenta;
        }).toList();

        return new ReporteEstadoCuentaDTO(clienteDTO, cuentasDTO);
    }
}