package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.EntadaCombustibleDto;

import java.util.List;

public interface EntradaCombustibleService {
    EntadaCombustibleDto crearEntradaCombustible(EntadaCombustibleDto entadaCombustibleDto);

    List<EntadaCombustibleDto> getAllEntradasCombustible();
}
