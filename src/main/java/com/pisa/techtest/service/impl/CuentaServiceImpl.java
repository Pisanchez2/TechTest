package com.pisa.techtest.service.impl;

import com.pisa.techtest.domain.Cuenta;
import com.pisa.techtest.repository.CuentaRepository;
import com.pisa.techtest.service.CuentaService;
import com.pisa.techtest.service.dto.CuentaDTO;
import com.pisa.techtest.service.mapper.CuentaMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    private final CuentaMapper cuentaMapper = CuentaMapper.INSTANCE;

    public List<CuentaDTO> getAllCuentas() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        return cuentas.stream().map(cuentaMapper::toDto).collect(Collectors.toList());
    }

    public CuentaDTO getCuentaById(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta no encontrada"));
        return cuentaMapper.toDto(cuenta);
    }

    @Override
    public List<CuentaDTO> getCuentasByClientId(Long id) {
        List<Cuenta> cuentas = cuentaRepository.getCuentasByCliente_Id(id);
        return cuentas.stream().map(cuentaMapper::toDto).collect(Collectors.toList());
    }

    public CuentaDTO getCuentaByNumeroCuenta(String cuentaId) {
        Cuenta cuenta = cuentaRepository.getTopByNumeroCuentaOrderByIdDesc(cuentaId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta no encontrada"));
        return cuentaMapper.toDto(cuenta);
    }

    public CuentaDTO saveCuenta(CuentaDTO cuentaDTO) {
        Cuenta cuenta = cuentaMapper.toEntity(cuentaDTO);
        Cuenta savedCuenta = cuentaRepository.save(cuenta);
        return cuentaMapper.toDto(savedCuenta);
    }

    public CuentaDTO updateCuenta(Long id, CuentaDTO cuentaDTO) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta no encontrada"));
        cuenta.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        cuenta.setTipoCuenta(cuentaDTO.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaDTO.getSaldoInicial());
        cuenta.setEstado(cuentaDTO.isEstado());
        Cuenta updatedCuenta = cuentaRepository.save(cuenta);
        return cuentaMapper.toDto(updatedCuenta);
    }

    public void deleteCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}