package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.TipoVentaDto;
import es.felix.grifo_asto.entity.TipoVenta;

public class TipoVentaMapper {
    public static TipoVentaDto mapToTipoVentaDto(TipoVenta ent) {
        return new TipoVentaDto(
                ent.getIdTipoVenta(),
                ent.getTipo(),
                ent.getCodigo(),
                ent.getStatus(),
                ent.getOrganization()
        );
    }
    public static TipoVenta mapToTipoVenta(TipoVentaDto entDto) {
        return new TipoVenta(
                entDto.getIdTipoVenta(),
                entDto.getTipo(),
                entDto.getCodigo(),
                entDto.getStatus(),
                entDto.getOrganization()
        );
    }
}
