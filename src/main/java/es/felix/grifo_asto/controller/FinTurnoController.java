package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.controller.convert.GeneralResponse;
import es.felix.grifo_asto.dto.FinTurnoDto;
import es.felix.grifo_asto.service.FinTurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/turno")
public class FinTurnoController {
    FinTurnoService finTurnoService;

    @GetMapping("/list")
    public ResponseEntity<GeneralResponse<List<FinTurnoDto>>> getAllFinTurnos() {
        List<FinTurnoDto> entrada = finTurnoService.listAllFinTurnos();
        GeneralResponse<List<FinTurnoDto>> generalResponse = new GeneralResponse<>();
        try {
            generalResponse.setCode(200);
            generalResponse.setMessage("OK");
            generalResponse.setData(entrada);
        }  catch (Exception e) {
            generalResponse.setCode(500);
            generalResponse.setMessage(e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(generalResponse);
        }
        return ResponseEntity.ok(generalResponse);
    }
    @PostMapping("/registrar")
    public ResponseEntity<FinTurnoDto> createFinTurno(@RequestBody FinTurnoDto finTurnoDto){
        FinTurnoDto turno = finTurnoService.createFinTurno(finTurnoDto);
        return new ResponseEntity<>(turno, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<FinTurnoDto> updatePersona(@PathVariable("id") Long id, @RequestBody FinTurnoDto turnoDto) {
        FinTurnoDto turno = finTurnoService.updateFinTurno(id, turnoDto);
        return new  ResponseEntity<>(turno, HttpStatus.OK);
    }
}
