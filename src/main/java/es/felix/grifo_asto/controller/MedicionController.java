package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.dto.MedicionRequestDto;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.service.MedicionService;
import es.felix.grifo_asto.shared.PaginationResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    @PutMapping("{id}")
    public ResponseEntity<MedicionDto> updateMedicion(@PathVariable("id") Long id, @RequestBody MedicionRequestDto medicionDto) {
        MedicionDto createMedicionDto = medicionService.updateMedicion(id, medicionDto);
        return new ResponseEntity<>(createMedicionDto, HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<PaginationResponse<MedicionDto>> getAllMediciones(@PageableDefault(sort = "fechaMedicion", direction = Sort.Direction.DESC)Pageable pageable) {
        Page<MedicionDto> page = medicionService.getAllMedicion(pageable);
        return ResponseEntity.ok(PaginationResponse.fromPage(page));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MedicionDto> deleteMedicion(@PathVariable("id") Long id){
        medicionService.deleteMedicion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
