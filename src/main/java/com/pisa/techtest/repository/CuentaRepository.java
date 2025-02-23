package com.pisa.techtest.repository;

import com.pisa.techtest.domain.Cuenta;
import com.pisa.techtest.service.dto.CuentaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Optional<Cuenta> getTopByNumeroCuentaOrderByIdDesc(String numeroCuenta);

    List<Cuenta> getCuentasByCliente_Id(Long clienteId);
}
