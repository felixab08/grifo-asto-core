package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.DetalleVentaDto;
import es.felix.grifo_asto.entity.DetalleVenta;

public class DetalleVentaMapper {

    public static DetalleVentaDto mapToDetalleVentaDto(DetalleVenta ent) {
        return new DetalleVentaDto(
                ent.getIdDetalleVenta(),
                ent.getNumVale(),
                ent.getPersona(),
                ent.getArea(),
                ent.getPlaca(),
                ent.getFechaVenta(),
                ent.getDiesel(),
                ent.getRegular(),
                ent.getPremiun(),
                ent.getTipoVenta()
        );
    }
    public static DetalleVenta mapToDetalleVenta(DetalleVentaDto ent) {
        return new DetalleVenta(
                ent.getIdDetalleVenta(),
                ent.getNumVale(),
                ent.getPersona(),
                ent.getArea(),
                ent.getPlaca(),
                ent.getFechaVenta(),
                ent.getDiesel(),
                ent.getRegular(),
                ent.getPremiun(),
                ent.getTipoVenta()
        );
    }
}
