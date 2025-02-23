package com.pisa.techtest.service;

import com.pisa.techtest.service.dto.MovimientoDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MovimientoService {

    public List<MovimientoDTO> getAllMovimientos();

    public List<MovimientoDTO> getMovimientosByCuentaIdAndFechaBetween(Date fechaInicio, Date fechaFin, String numeroCuenta);

    public MovimientoDTO getMovimientoById(Long id);

    public MovimientoDTO saveMovimiento(MovimientoDTO movimientoDTO);

    public MovimientoDTO updateMovimiento(Long id, MovimientoDTO movimientoDTO);

    public void deleteMovimiento(Long id);
}