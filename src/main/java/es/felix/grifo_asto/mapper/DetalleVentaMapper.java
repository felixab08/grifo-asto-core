package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.DetalleVentaDto;
import es.felix.grifo_asto.entity.DetalleVenta;

public class DetalleVentaMapper {

    public static DetalleVentaDto mapToDetalleVentaDto(DetalleVenta ent) {
      DetalleVentaDto  dto = new DetalleVentaDto();
                dto.setIdDetalleVenta(ent.getIdDetalleVenta());
                dto.setNumVale(ent.getNumVale());
                dto.setPersona(ent.getPersona());
                dto.setPlaca(ent.getPlaca());
                dto.setArea(ent.getArea());
                dto.setFechaVenta(ent.getFechaVenta());
                dto.setDiesel(ent.getDiesel());
                dto.setRegular(ent.getRegular());
                dto.setPremiun(ent.getPremiun());
                dto.setTipoVenta(ent.getTipoVenta());
        return dto;
    }
    public static DetalleVenta mapToDetalleVenta(DetalleVentaDto entDto) {
       DetalleVenta ent =  new DetalleVenta();
                ent.setIdDetalleVenta(entDto.getIdDetalleVenta());
                ent.setNumVale(entDto.getNumVale());
                ent.setPersona(entDto.getPersona());
                ent.setArea(entDto.getArea());
                ent.setPlaca(entDto.getPlaca());
                ent.setFechaVenta(entDto.getFechaVenta());
                ent.setDiesel(entDto.getDiesel());
                ent.setRegular(entDto.getRegular());
                ent.setPremiun(entDto.getPremiun());
                ent.setTipoVenta(entDto.getTipoVenta());
        return ent;
    }
}
