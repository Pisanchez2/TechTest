package com.pisa.techtest.service.mapper;

import com.pisa.techtest.domain.Cuenta;
import com.pisa.techtest.service.dto.CuentaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CuentaMapper {

    CuentaMapper INSTANCE = Mappers.getMapper(CuentaMapper.class);

    @Mapping(target = "clienteId", source = "cliente.id")
    CuentaDTO toDto(Cuenta cuenta);

    @Mapping(target = "cliente.id", source = "clienteId")
    Cuenta toEntity(CuentaDTO cuentaDTO);

}