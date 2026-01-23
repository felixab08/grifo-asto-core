package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.TipoVenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleVentaDto {
    private Long idDetalleVenta;
    private String numVale;
    private String persona;
    private String placa;
    private String area;
    private Date fechaVenta;
    private Double diesel;
    private Double regular;
    private Double premiun;
    private TipoVenta tipoVenta;
}
