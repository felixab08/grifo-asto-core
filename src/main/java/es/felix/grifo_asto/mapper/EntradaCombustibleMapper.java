package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.EntradaCombustibleDto;
import es.felix.grifo_asto.entity.EntradaCombustible;

public class EntradaCombustibleMapper {
    public static EntradaCombustibleDto mapToEntradaCombustibleDto(EntradaCombustible ent) {
        EntradaCombustibleDto  entrada = new EntradaCombustibleDto();

            entrada.setIdEntrada( ent.getIdEntrada());
            entrada.setTipo(ent.getTipo());
            entrada.setCantidad(ent.getCantidad());
            entrada.setFechaEntrada(ent.getFechaEntrada());
            entrada.setPersona(ent.getPersona());
        return entrada;
    }

    public static EntradaCombustible mapToEntradaCombustible(EntradaCombustibleDto ent) {
        EntradaCombustible entrada = new EntradaCombustible();
            entrada.setIdEntrada( ent.getIdEntrada());
            entrada.setTipo(ent.getTipo());
            entrada.setCantidad(ent.getCantidad());
            entrada.setFechaEntrada(ent.getFechaEntrada());
            entrada.setPersona(ent.getPersona());
        return entrada;
    }
}
