package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.controller.convert.GeneralResponse;
import es.felix.grifo_asto.dto.PersonaDto;
import es.felix.grifo_asto.service.PersonaService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/persona")
public class PersonaController {
    PersonaService personaService;
    private static final Logger log = LoggerFactory.getLogger(MedicionController.class);


    @PostMapping("/registrar")
    public ResponseEntity<PersonaDto> createPersona(@RequestBody PersonaDto personaDto) {
        PersonaDto savedPersona = personaService.createPersona(personaDto);
        return new  ResponseEntity<>(savedPersona, HttpStatus.CREATED);
    }
    // Build Update Persona REST API
    @PutMapping("{id}")
    public ResponseEntity<PersonaDto> updatePersona(@PathVariable("id") Long id, @RequestBody PersonaDto updatePersonaDto) {
        PersonaDto personaDto = personaService.updatePersona(id, updatePersonaDto);
        return new  ResponseEntity<>(personaDto, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<PersonaDto> getPersonaById(@PathVariable("id") Long id){
        PersonaDto personaDto = personaService.getPersonaById(id);
        log.info("CONTROLLER LISTAR PERSONA: {}", personaDto);

        return ResponseEntity.ok(personaDto);
    }
    // Biuld Get All Personas REST API
    @GetMapping("/list")
    public ResponseEntity<GeneralResponse<List<PersonaDto>>> getAllPersonas() {
        List<PersonaDto> personasDto = personaService.getAllPersonas();
        GeneralResponse<List<PersonaDto>> respuestaGeneral = new GeneralResponse<>();
        try {
            respuestaGeneral.setCode(200);
            respuestaGeneral.setMessage("OK");
            respuestaGeneral.setData(personasDto);
        } catch (Exception e) {
            respuestaGeneral.setCode(500);
            respuestaGeneral.setMessage(e.getMessage());
            respuestaGeneral.setData(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaGeneral);
        }
        return ResponseEntity.ok(respuestaGeneral);
    }

    // Build Delete Persola REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable("id") Long id){
        personaService.deletePersona(id);
        return ResponseEntity.ok("Persona eliminada con exito");
    }

}
