package com.pisa.techtest.web.rest;

import com.pisa.techtest.service.ReporteService;
import com.pisa.techtest.service.dto.ReporteEstadoCuentaDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping
    public ResponseEntity<?> generarReporte(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin,
            @RequestParam("clienteId") Long clienteId) {

        // Servicio genera el reporte
        ReporteEstadoCuentaDTO reporte = reporteService.generarReporte(fechaInicio, fechaFin, clienteId);

        // Respuesta
        return ResponseEntity.ok(reporte);
    }
}