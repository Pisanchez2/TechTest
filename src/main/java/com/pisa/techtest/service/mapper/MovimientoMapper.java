package com.pisa.techtest.service.mapper;

import com.pisa.techtest.domain.Movimiento;
import com.pisa.techtest.service.dto.MovimientoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {})
public interface MovimientoMapper {

    MovimientoMapper INSTANCE = Mappers.getMapper(MovimientoMapper.class);

    @Mapping(target = "cuentaId", source = "cuenta.id")
    MovimientoDTO toDto(Movimiento movimiento);

    @Mapping(target = "cuenta.id", source = "cuentaId")
    Movimiento toEntity(MovimientoDTO movimientoDTO);
}