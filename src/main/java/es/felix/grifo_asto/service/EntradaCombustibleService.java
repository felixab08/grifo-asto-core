package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.EntradaCombustibleDto;

import java.util.List;

public interface EntradaCombustibleService {
    EntradaCombustibleDto crearEntradaCombustible(EntradaCombustibleDto entadaCombustibleDto);

    List<EntradaCombustibleDto> getAllEntradasCombustible(Integer cantidad);
}
