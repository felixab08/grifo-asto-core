package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.PersonaDto;
import es.felix.grifo_asto.entity.Persona;

public class PersonaMapper {

    public static PersonaDto mapToPersonaDto(Persona persona) {
        PersonaDto dto = new PersonaDto();
        dto.setIdPersona(persona.getIdPersona());
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setTelefono(persona.getTelefono());
        dto.setEmail(persona.getEmail());
        dto.setUsername(persona.getUsername());
        dto.setRole(persona.getRole() != null ? persona.getRole().name() : null);
        dto.setActivo(persona.getActivo());
        dto.setFechaCreate(persona.getFechaCreate());
        // Note: Do NOT include password in DTO
        return dto;
    }

    public static Persona mapToPersona(PersonaDto personaDto) {
        Persona persona = new Persona();
        persona.setIdPersona(personaDto.getIdPersona());
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setTelefono(personaDto.getTelefono());
        persona.setEmail(personaDto.getEmail());
        persona.setUsername(personaDto.getUsername());
        // Role, activo, and password should NOT be set from DTO for security
        persona.setFechaCreate(personaDto.getFechaCreate());
        return persona;
    }

}
