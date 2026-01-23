package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.config.Constants;
import es.felix.grifo_asto.dto.DetalleVentaDto;
import es.felix.grifo_asto.dto.filter.FilterDto;
import es.felix.grifo_asto.service.DetalleVentaService;
import es.felix.grifo_asto.shared.PaginationResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@AllArgsConstructor
@RestController
@RequestMapping("api/detalle-venta")
public class DetalleVentaController {
    private DetalleVentaService detalleVentaService;

    @PostMapping("/registrar")
    public ResponseEntity<DetalleVentaDto> createDetalleVenta(@RequestBody DetalleVentaDto detalleVentaDto) {
        DetalleVentaDto save =  detalleVentaService.createDetalleVenta(detalleVentaDto);
        return new  ResponseEntity<>(save, HttpStatus.CREATED);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<DetalleVentaDto> updateDetalleVenta(@PathVariable("id") Long id, @RequestBody DetalleVentaDto detalleVentaDto) {
        DetalleVentaDto update = detalleVentaService.updateDetalleVenta(id, detalleVentaDto);
        return new  ResponseEntity<>(update, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDetalleVentaById(@PathVariable("id") Long id){
        detalleVentaService.deleteDetalleVenta(id);
        return ResponseEntity.ok(Constants.DELETE_MESAJE);
    }
    @GetMapping("/list")
    public ResponseEntity<PaginationResponse<DetalleVentaDto>> getAllDetalleVenta(
            Pageable pageable,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = true) Long id) {

        FilterDto filterDto = FilterDto.builder()
                .id(id)
                .startDate(startDate)
                .endDate(endDate)
                .build();

        Page<DetalleVentaDto> page = detalleVentaService.getDetalleVenta(filterDto, pageable);
        return ResponseEntity.ok(PaginationResponse.fromPage(page));
    }
}
