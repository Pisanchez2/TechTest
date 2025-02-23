package com.pisa.techtest.service.impl;

import com.pisa.techtest.domain.Persona;
import com.pisa.techtest.repository.PersonaRepository;
import com.pisa.techtest.service.PersonaService;
import com.pisa.techtest.service.dto.PersonaDTO;
import com.pisa.techtest.service.mapper.PersonaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    private final PersonaMapper personaMapper = PersonaMapper.INSTANCE;

    public List<PersonaDTO> getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream().map(personaMapper::toDto).collect(Collectors.toList());
    }

    public PersonaDTO getPersonaById(Long id) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        return personaMapper.toDto(persona);
    }

    public PersonaDTO savePersona(PersonaDTO personaDTO) {
        Persona persona = personaMapper.toEntity(personaDTO);
        Persona savedPersona = personaRepository.save(persona);
        return personaMapper.toDto(savedPersona);
    }

    public PersonaDTO updatePersona(Long id, PersonaDTO personaDTO) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        persona.setNombre(personaDTO.getNombre());
        persona.setGenero(personaDTO.getGenero());
        persona.setEdad(personaDTO.getEdad());
        persona.setIdentificacion(personaDTO.getIdentificacion());
        persona.setDireccion(personaDTO.getDireccion());
        persona.setTelefono(personaDTO.getTelefono());
        Persona updatedPersona = personaRepository.save(persona);
        return personaMapper.toDto(updatedPersona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}