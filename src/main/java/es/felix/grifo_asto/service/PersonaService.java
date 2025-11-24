package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.PersonaDto;

import java.util.List;

public interface PersonaService {
    PersonaDto createPersona(PersonaDto personaDto);
    PersonaDto updatePersona(Long id, PersonaDto personaDto);

    PersonaDto getPersonaById(Long id);
    List<PersonaDto> getAllPersonas();

    void deletePersona(Long id);

}
