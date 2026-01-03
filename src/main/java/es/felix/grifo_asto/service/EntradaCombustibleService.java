package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.EntradaCombustibleDto;



public interface EntradaCombustibleService {
    EntradaCombustibleDto crearEntradaCombustible(EntradaCombustibleDto entadaCombustibleDto);

    org.springframework.data.domain.Page<EntradaCombustibleDto> getAllEntradasCombustible(org.springframework.data.domain.Pageable pageable);
}
