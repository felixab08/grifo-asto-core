package es.felix.grifo_asto.controller;


import es.felix.grifo_asto.dto.EntradaCombustibleDto;
import es.felix.grifo_asto.service.EntradaCombustibleService;
import es.felix.grifo_asto.shared.PaginationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@RestController
@RequestMapping("api/entrada-combustible")
public class EntradaCombustibleController {
    EntradaCombustibleService entradaCombustibleSrv;

    @GetMapping("/list")
    public ResponseEntity<PaginationResponse<EntradaCombustibleDto>> getAllEntradas(
            org.springframework.data.domain.Pageable pageable) {
        org.springframework.data.domain.Page<EntradaCombustibleDto> page = entradaCombustibleSrv.getAllEntradasCombustible(pageable);
        return ResponseEntity.ok(PaginationResponse.fromPage(page));
    }

    @PostMapping("/registrar")
    public ResponseEntity<EntradaCombustibleDto> createMedicion(@RequestBody EntradaCombustibleDto entradaDto){
        EntradaCombustibleDto entrada = entradaCombustibleSrv.crearEntradaCombustible(entradaDto);
        return new ResponseEntity<>(entrada, HttpStatus.CREATED);
    }
}
