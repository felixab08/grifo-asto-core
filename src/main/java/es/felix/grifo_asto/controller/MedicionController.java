package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.dto.MedicionRequestDto;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.service.MedicionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@RestController
@RequestMapping("api/medicion")
public class MedicionController {

    MedicionService medicionService;


    @PostMapping("/registrar")
    public ResponseEntity<MedicionDto> createMedicion(@RequestBody MedicionRequestDto medicionDto){
        MedicionDto createMedicionDto = medicionService.createMedicion(medicionDto);
        return new ResponseEntity<>(createMedicionDto, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<es.felix.grifo_asto.shared.PaginationResponse<MedicionDto>> getAllMediciones(
            org.springframework.data.domain.Pageable pageable) {
        org.springframework.data.domain.Page<MedicionDto> page = medicionService.getAllMedicion(pageable);
        return ResponseEntity.ok(es.felix.grifo_asto.shared.PaginationResponse.fromPage(page));
    }
}
