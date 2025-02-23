package com.pisa.techtest.service;

import com.pisa.techtest.service.dto.ReporteEstadoCuentaDTO;

import java.time.LocalDate;
import java.util.Date;

public interface ReporteService {

    public ReporteEstadoCuentaDTO generarReporte(Date fechaInicio, Date fechaFin, Long clienteId);
}
