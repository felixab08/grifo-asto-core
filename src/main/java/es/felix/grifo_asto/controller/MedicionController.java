package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.service.MedicionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/medicion")
public class MedicionController {
    MedicionService medicionService;

    @PostMapping("/registrar")
    public ResponseEntity<MedicionDto> createMedicion(@RequestBody MedicionDto medicionDto){
        MedicionDto createMedicionDto = medicionService.createMedicion(medicionDto);
        return new ResponseEntity<>(createMedicionDto, HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ResponseEntity<List<MedicionDto>> getAllMediciones() {
        List<MedicionDto> mediciones = medicionService.getAllMedicion();
        return ResponseEntity.ok(mediciones);
    }
}
