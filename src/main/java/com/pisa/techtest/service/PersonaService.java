package com.pisa.techtest.service;

import com.pisa.techtest.service.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {

    public List<PersonaDTO> getAllPersonas();

    public PersonaDTO getPersonaById(Long id);

    public PersonaDTO savePersona(PersonaDTO personaDTO);

    public PersonaDTO updatePersona(Long id, PersonaDTO personaDTO);

    public void deletePersona(Long id);
}