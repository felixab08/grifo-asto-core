package es.felix.grifo_asto.controller;


import es.felix.grifo_asto.dto.EntradaCombustibleDto;
import es.felix.grifo_asto.service.EntradaCombustibleService;
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
@RequestMapping("api/entrada-combustible")
public class EntradaCombustibleController {
    EntradaCombustibleService entradaCombustibleSrv;

    @GetMapping("/list")
    public ResponseEntity<PaginationResponse<EntradaCombustibleDto>> getAllEntradas(
            @PageableDefault(sort = "fechaEntrada", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<EntradaCombustibleDto> page = entradaCombustibleSrv.getAllEntradasCombustible(pageable);
        return ResponseEntity.ok(PaginationResponse.fromPage(page));
    }

    @PutMapping("{id}")
    public ResponseEntity<EntradaCombustibleDto> updateEntrada(@PathVariable("id") Long id, @RequestBody EntradaCombustibleDto entradaDto) {
        EntradaCombustibleDto entrada = entradaCombustibleSrv.updateEntradaCombustible(id, entradaDto);
        return new  ResponseEntity<>(entrada, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<EntradaCombustibleDto> createMedicion(@RequestBody EntradaCombustibleDto entradaDto){
        EntradaCombustibleDto entrada = entradaCombustibleSrv.crearEntradaCombustible(entradaDto);
        return new ResponseEntity<>(entrada, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EntradaCombustibleDto> deleteMedicion(@PathVariable Long id){
        entradaCombustibleSrv.deleteEntradaCombustible(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
