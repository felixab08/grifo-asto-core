package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.TipoVentaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TipoVentaService {

    TipoVentaDto createTipoVenta(TipoVentaDto tipoVentaDto);
    TipoVentaDto updateTipoVenta(Long id, TipoVentaDto tipoVentaDto);
    Page<TipoVentaDto> getAllTipoVentas(Pageable pageable);

}
