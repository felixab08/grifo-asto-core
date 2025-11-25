package es.felix.grifo_asto.controller;
import es.felix.grifo_asto.controller.convert.GeneralResponse;
import es.felix.grifo_asto.dto.MedicionRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.service.MedicionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/medicion")
public class MedicionController {

    MedicionService medicionService;

    private static final Logger log = LoggerFactory.getLogger(MedicionController.class);


    @PostMapping("/registrar")
    public ResponseEntity<MedicionDto> createMedicion(@RequestBody MedicionRequestDto medicionDto){
        MedicionDto createMedicionDto = medicionService.createMedicion(medicionDto);
        return new ResponseEntity<>(createMedicionDto, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<GeneralResponse<List<MedicionDto>>> getAllMediciones() {
        List<MedicionDto> mediciones = medicionService.getAllMedicion();
        GeneralResponse<List<MedicionDto>> generalResponse = new GeneralResponse<>();
        try {
            generalResponse.setCode(200);
            generalResponse.setMessage("OK");
            generalResponse.setData(mediciones);
        }  catch (Exception e) {
            generalResponse.setCode(500);
            generalResponse.setMessage(e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(generalResponse);
        }
        return ResponseEntity.ok(generalResponse);
    }
}
