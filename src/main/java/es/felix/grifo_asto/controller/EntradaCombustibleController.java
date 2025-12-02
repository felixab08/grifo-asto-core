package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.controller.convert.GeneralResponse;
import es.felix.grifo_asto.dto.EntradaCombustibleDto;
import es.felix.grifo_asto.service.EntradaCombustibleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/entrada-combustible")
public class EntradaCombustibleController {
    EntradaCombustibleService entradaCombustibleSrv;

    @GetMapping("/list")
    public ResponseEntity<GeneralResponse<List<EntradaCombustibleDto>>> getAllMediciones(@RequestParam(value = "cantidad", required = false, defaultValue = "10") Integer cantidad) {
        List<EntradaCombustibleDto> entrada = entradaCombustibleSrv.getAllEntradasCombustible(cantidad);
        GeneralResponse<List<EntradaCombustibleDto>> generalResponse = new GeneralResponse<>();
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
    public ResponseEntity<EntradaCombustibleDto> createMedicion(@RequestBody EntradaCombustibleDto entradaDto){
        EntradaCombustibleDto entrada = entradaCombustibleSrv.crearEntradaCombustible(entradaDto);
        return new ResponseEntity<>(entrada, HttpStatus.CREATED);
    }
}
