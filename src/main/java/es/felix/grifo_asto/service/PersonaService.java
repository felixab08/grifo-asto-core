package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.PersonaDto;
import org.springframework.data.domain.Pageable;


public interface PersonaService {
    PersonaDto createPersona(PersonaDto personaDto);
    PersonaDto updatePersona(Long id, PersonaDto personaDto);

    PersonaDto getPersonaById(Long id);
    org.springframework.data.domain.Page<PersonaDto> getAllPersonas(Pageable pageable);

    void deletePersona(Long id);

}
