package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.PersonaDto;
import es.felix.grifo_asto.entity.Persona;
import es.felix.grifo_asto.exception.ResourceNotFoundException;
import es.felix.grifo_asto.mapper.PersonaMapper;
import es.felix.grifo_asto.repository.PersonaRepository;
import es.felix.grifo_asto.service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService {
    private PersonaRepository personaRepository;
    @Override
    public PersonaDto createPersona(PersonaDto personaDto) {
        Persona persona = PersonaMapper.mapToPersona(personaDto);
        Persona savedPersona = personaRepository.save(persona);
        return PersonaMapper.mapToPersonaDto(savedPersona);
    }

    @Override
    public PersonaDto updatePersona(Long id, PersonaDto personaDto) {
        Persona persona =  personaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Persona no encontrado" + id));
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setFechaCreate(personaDto.getFechaCreate());
        persona.setTelefono(personaDto.getTelefono());
        Persona updatePersonaObj = personaRepository.save(persona);
        return PersonaMapper.mapToPersonaDto(updatePersonaObj);
    }

    @Override
    public PersonaDto getPersonaById(Long id) {
      Persona persona =  personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la persona" + id));
        return PersonaMapper.mapToPersonaDto(persona);
    }

    @Override
    public List<PersonaDto> getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream().map((persona)-> PersonaMapper.mapToPersonaDto(persona)).collect(Collectors.toList());
    }

    @Override
    public void deletePersona(Long id) {
        Persona persona =  personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la persona" + id));
        personaRepository.deleteById(id);
    }
}
