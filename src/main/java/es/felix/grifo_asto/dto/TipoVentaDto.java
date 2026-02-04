package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoVentaDto {
    private Long idTipoVenta;
    private String tipo;
    private String codigo;
    private Boolean status;
    private Organization organization;
    private Double diesel;
    private Double regular;
    private Double premiun;
}
