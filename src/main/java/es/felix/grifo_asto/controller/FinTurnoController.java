package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.dto.FinTurnoDto;
import es.felix.grifo_asto.dto.FinTurnoResponse;
import es.felix.grifo_asto.service.FinTurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/turno")
public class FinTurnoController {
    FinTurnoService finTurnoService;

    @GetMapping("/list/{idPersona}")
    public ResponseEntity<FinTurnoResponse> getAllFinTurnos(@PathVariable Long idPersona) {
        FinTurnoResponse response = finTurnoService.getFinTurnosByPersona(idPersona);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/registrar")
    public ResponseEntity<FinTurnoDto> createFinTurno(@RequestBody FinTurnoDto finTurnoDto){
        FinTurnoDto turno = finTurnoService.createFinTurno(finTurnoDto);
        return new ResponseEntity<>(turno, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FinTurnoDto> updatePersona(@PathVariable("id") Long id, @RequestBody FinTurnoDto finTurnoDto) {
        FinTurnoDto turno = finTurnoService.updateFinTurno(id, finTurnoDto);
        return new  ResponseEntity<>(turno, HttpStatus.OK);
    }
}
