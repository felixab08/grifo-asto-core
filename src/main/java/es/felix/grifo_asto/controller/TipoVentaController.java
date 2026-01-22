package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.dto.OrganizationDto;
import es.felix.grifo_asto.dto.TipoVentaDto;
import es.felix.grifo_asto.dto.filter.FilterDto;
import es.felix.grifo_asto.service.TipoVentaService;
import es.felix.grifo_asto.shared.PaginationResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/tipo-venta")
public class TipoVentaController {
    private TipoVentaService tipoVentaService;

    @PostMapping("/registrar")
    public ResponseEntity<TipoVentaDto> createTipoVenta(@RequestBody TipoVentaDto tipoVentaDto) {
        TipoVentaDto savetipoventa =  tipoVentaService.createTipoVenta(tipoVentaDto);
        return new  ResponseEntity<>(savetipoventa, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<TipoVentaDto> updateTipoVenta(@PathVariable("id") Long id, @RequestBody TipoVentaDto tipoVentaDto) {
        TipoVentaDto updateTipoventa = tipoVentaService.updateTipoVenta(id, tipoVentaDto);
        return new  ResponseEntity<>(updateTipoventa, HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<PaginationResponse<TipoVentaDto>> getAllTipoVentas(
            Pageable pageable,
            @RequestParam(required = false) Boolean status,
            @RequestParam(required = false) Long id) {

        FilterDto filterDto = FilterDto.builder()
                .id(id)
                .status(status)
                .build();

        Page<TipoVentaDto> page = tipoVentaService.getAllTipoVentas(filterDto, pageable);
        return ResponseEntity.ok(PaginationResponse.fromPage(page));
    }
}
