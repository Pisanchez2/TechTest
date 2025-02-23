package com.pisa.techtest.service.impl;

import com.pisa.techtest.domain.Movimiento;
import com.pisa.techtest.repository.MovimientoRepository;
import com.pisa.techtest.service.MovimientoService;
import com.pisa.techtest.service.dto.CuentaDTO;
import com.pisa.techtest.service.dto.MovimientoDTO;
import com.pisa.techtest.service.mapper.MovimientoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final CuentaServiceImpl cuentaService;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository, CuentaServiceImpl cuentaService) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaService = cuentaService;
    }

    private final MovimientoMapper movimientoMapper = MovimientoMapper.INSTANCE;

    public List<MovimientoDTO> getAllMovimientos() {
        List<Movimiento> movimientos = movimientoRepository.findAll();
        return movimientos.stream().map(movimientoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<MovimientoDTO> getMovimientosByCuentaIdAndFechaBetween(Date fechaInicio, Date fechaFin, String numeroCuenta) {
        List<Movimiento> movimientos = movimientoRepository.findByCuenta_NumeroCuentaAndFechaBetween(numeroCuenta, fechaInicio, fechaFin);
        return movimientos.stream().map(movimientoMapper::toDto).collect(Collectors.toList());
    }

    public MovimientoDTO getMovimientoById(Long id) {
        Movimiento movimiento = movimientoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movimiento no encontrado"));
        return movimientoMapper.toDto(movimiento);
    }

    public MovimientoDTO saveMovimiento(MovimientoDTO movimientoDTO) {
        double saldo = 0;

        CuentaDTO cuentaDTO = cuentaService.getCuentaByNumeroCuenta(movimientoDTO.getNumeroCuenta());
        saldo = cuentaDTO.getSaldoInicial();

        Optional<Movimiento> lastMovimiento = movimientoRepository.findTopByCuentaIdOrderByIdDesc(cuentaDTO.getId());
        if (lastMovimiento.isPresent()) {
            saldo = lastMovimiento.get().getSaldo();
        }

        double valor = movimientoDTO.getValor();

        if (valor == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor no puede ser 0");
        }

        if (saldo + valor < 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Saldo insuficiente");
        }

        movimientoDTO.setSaldo(saldo + valor);

        if (valor < 0) {
            movimientoDTO.setTipoMovimiento("Retiro de " + valor);
        } else {
            movimientoDTO.setTipoMovimiento("Deposito de " + valor);
        }

        movimientoDTO.setFecha(new Date());
        movimientoDTO.setCuentaId(cuentaDTO.getId());

        Movimiento movimiento = movimientoMapper.toEntity(movimientoDTO);
        Movimiento savedMovimiento = movimientoRepository.save(movimiento);
        return movimientoMapper.toDto(savedMovimiento);
    }

    public MovimientoDTO updateMovimiento(Long id, MovimientoDTO movimientoDTO) {
        Movimiento movimiento = movimientoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movimiento no encontrado"));
        movimiento.setFecha(movimientoDTO.getFecha());
        movimiento.setTipoMovimiento(movimientoDTO.getTipoMovimiento());
        movimiento.setValor(movimientoDTO.getValor());
        movimiento.setSaldo(movimientoDTO.getSaldo());
        Movimiento updatedMovimiento = movimientoRepository.save(movimiento);
        return movimientoMapper.toDto(updatedMovimiento);
    }

    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
}