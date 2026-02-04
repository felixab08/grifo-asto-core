package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.dto.FinTurnoDto;
import es.felix.grifo_asto.dto.FinTurnoResponse;
import es.felix.grifo_asto.dto.ReporteFinTurnoResponse;
import es.felix.grifo_asto.dto.request.turno.FinTurnoFilterDto;
import es.felix.grifo_asto.service.FinTurnoService;
import es.felix.grifo_asto.shared.PaginationResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("api/turno")
public class FinTurnoController {
    
    @Autowired
   private final FinTurnoService finTurnoService;
    private static final Logger log = LoggerFactory.getLogger(FinTurnoController.class);


    @GetMapping("/list/{idPersona}")
    public ResponseEntity<FinTurnoResponse> getAllFinTurnos(@PathVariable Long idPersona, @RequestParam(defaultValue = "10") int size) {
        FinTurnoResponse response = finTurnoService.getFinTurnosByPersona(idPersona, size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<PaginationResponse<FinTurnoDto>> getAllFinTurnos(
            @ModelAttribute FinTurnoFilterDto filter,
            Pageable pageable) {
        Page<FinTurnoDto> page = finTurnoService.getAllFinTurnos(filter, pageable);
        return ResponseEntity.ok(PaginationResponse.fromPage(page));
    }

    @PostMapping("/registrar")
    public ResponseEntity<FinTurnoDto> createFinTurno(@RequestBody FinTurnoDto finTurnoDto){
        FinTurnoDto turno = finTurnoService.createFinTurno(finTurnoDto);
        return new ResponseEntity<>(turno, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FinTurnoDto> updatePersona(@PathVariable("id") Long id, @RequestBody FinTurnoDto finTurnoDto) {
        log.info("Findo de entrada:{}", finTurnoDto);
        FinTurnoDto turno = finTurnoService.updateFinTurno(id, finTurnoDto);
        return new  ResponseEntity<>(turno, HttpStatus.OK);
    }
    
    @GetMapping("/reporte/{year}")
    public ResponseEntity<ReporteFinTurnoResponse> getReporteAllFinTurnos(@PathVariable int year) {
        ReporteFinTurnoResponse response = finTurnoService.ReporteAllFinTurnos(year);
        return ResponseEntity.ok(response);
    }
}
