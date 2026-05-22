package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.EntradaCombustibleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EntradaCombustibleService {
    EntradaCombustibleDto crearEntradaCombustible(EntradaCombustibleDto entadaCombustibleDto);
    EntradaCombustibleDto updateEntradaCombustible(Long id, EntradaCombustibleDto entadaCombustibleDto);
    Page<EntradaCombustibleDto> getAllEntradasCombustible(Pageable pageable);
    void deleteEntradaCombustible(Long id);

}
