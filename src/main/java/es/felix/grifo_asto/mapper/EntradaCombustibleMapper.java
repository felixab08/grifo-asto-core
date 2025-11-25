package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.EntradaCombustibleDto;
import es.felix.grifo_asto.entity.EntradaCombustible;

public class EntradaCombustibleMapper {
    public static EntradaCombustibleDto mapToEntradaCombustibleDto(EntradaCombustible ent) {
        return new EntradaCombustibleDto(
                ent.getIdEntrada(),
                ent.getTipo(),
                ent.getCantidad(),
                ent.getFechaEntrada(),
                ent.getPersona()
        );
    }

    public static EntradaCombustible mapToEntradaCombustible(EntradaCombustibleDto ent) {
        return new EntradaCombustible(
                ent.getIdEntrada(),
                ent.getTipo(),
                ent.getCantidad(),
                ent.getFechaEntrada(),
                ent.getPersona()
        );
    }
}
