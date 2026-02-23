package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.EntradaCombustibleDto;
import org.springframework.data.domain.Pageable;


public interface EntradaCombustibleService {
    EntradaCombustibleDto crearEntradaCombustible(EntradaCombustibleDto entadaCombustibleDto);

    org.springframework.data.domain.Page<EntradaCombustibleDto> getAllEntradasCombustible(Pageable pageable);
}
