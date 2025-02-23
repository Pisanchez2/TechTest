package com.pisa.techtest.service.mapper;

import com.pisa.techtest.domain.Persona;
import com.pisa.techtest.service.dto.PersonaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {})
public interface PersonaMapper {

    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaDTO toDto(Persona persona);

    Persona toEntity(PersonaDTO personaDTO);
}