package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.EntadaCombustibleDto;
import es.felix.grifo_asto.entity.EntradaCombustible;

public class EntradaCombustibleMapper {
    public static EntadaCombustibleDto mapToEntradaCombustibleDto(EntradaCombustible ent) {
        return new EntadaCombustibleDto(
                ent.getIdEntrada(),
                ent.getTipo(),
                ent.getCantidad(),
                ent.getFechaEntrada(),
                ent.getPersona()
        );
    }

    public static EntradaCombustible mapToEntradaCombustible(EntadaCombustibleDto ent) {
        return new EntradaCombustible(
                ent.getIdEntrada(),
                ent.getTipo(),
                ent.getCantidad(),
                ent.getFechaEntrada(),
                ent.getPersona()
        );
    }
}
