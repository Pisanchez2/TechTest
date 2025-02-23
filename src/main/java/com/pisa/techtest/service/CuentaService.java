package com.pisa.techtest.service;

import com.pisa.techtest.service.dto.CuentaDTO;

import java.util.List;

public interface CuentaService {

    public List<CuentaDTO> getAllCuentas();

    public CuentaDTO getCuentaById(Long id);

    public List<CuentaDTO> getCuentasByClientId(Long id);

    public CuentaDTO getCuentaByNumeroCuenta(String cuentaId);

    public CuentaDTO saveCuenta(CuentaDTO cuentaDTO);

    public CuentaDTO updateCuenta(Long id, CuentaDTO cuentaDTO);

    public void deleteCuenta(Long id);
}