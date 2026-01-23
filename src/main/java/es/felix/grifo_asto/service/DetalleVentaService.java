package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.DetalleVentaDto;
import es.felix.grifo_asto.dto.filter.FilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DetalleVentaService {
    DetalleVentaDto createDetalleVenta(DetalleVentaDto dto);
    DetalleVentaDto updateDetalleVenta(Long id, DetalleVentaDto dto);
    Page<DetalleVentaDto> getDetalleVenta(FilterDto filterDto, Pageable pageable);
    void deleteDetalleVenta(Long id);
}
