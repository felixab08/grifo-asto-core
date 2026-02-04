package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.TipoVentaDto;
import es.felix.grifo_asto.entity.TipoVenta;

public class TipoVentaMapper {
    public static TipoVentaDto mapToTipoVentaDto(TipoVenta ent) {
       TipoVentaDto entDto =  new TipoVentaDto();
                entDto.setIdTipoVenta(ent.getIdTipoVenta());
                entDto.setTipo(ent.getTipo());
                entDto.setCodigo(ent.getCodigo());
                entDto.setStatus(ent.getStatus());
                entDto.setOrganization(ent.getOrganization());
                entDto.setPremiun(ent.getPremiun());
                entDto.setDiesel(ent.getDiesel());
                entDto.setRegular(ent.getRegular());
        return entDto;
    }
    public static TipoVenta mapToTipoVenta(TipoVentaDto entDto) {
       TipoVenta ent = new TipoVenta();
                ent.setIdTipoVenta(entDto.getIdTipoVenta());
                ent.setTipo(entDto.getTipo());
                ent.setCodigo(entDto.getCodigo());
                ent.setStatus(entDto.getStatus());
                ent.setOrganization(entDto.getOrganization());
                ent.setPremiun(entDto.getPremiun());
                ent.setDiesel(entDto.getDiesel());
                ent.setRegular(entDto.getRegular());
        return ent;
    }
}
