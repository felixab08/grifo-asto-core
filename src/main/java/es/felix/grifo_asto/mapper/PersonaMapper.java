package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.PersonaDto;
import es.felix.grifo_asto.entity.Persona;

public class PersonaMapper {

    public static PersonaDto mapToPersonaDto(Persona persona) {
        return new PersonaDto(
                persona.getIdPersona(),
                persona.getNombre(),
                persona.getApellido(),
                persona.getTelefono(),
                persona.getFechaCreate()
        );
    }

    public static Persona mapToPersona(PersonaDto personaDto) {
        return new Persona(
                personaDto.getIdPersona(),
                personaDto.getNombre(),
                personaDto.getApellido(),
                personaDto.getTelefono(),
                personaDto.getFechaCreate()
        );
    }

}
