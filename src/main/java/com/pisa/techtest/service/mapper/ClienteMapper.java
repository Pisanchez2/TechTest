package com.pisa.techtest.service.mapper;

import com.pisa.techtest.domain.Cliente;
import com.pisa.techtest.service.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {CuentaMapper.class})
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(target = "contraseña", ignore = true)
    @Mapping(target = "id", source = "id")
    ClienteDTO toDto(Cliente cliente);

    @Mapping(target = "id", source = "id")
    Cliente toEntity(ClienteDTO clienteDTO);
}
