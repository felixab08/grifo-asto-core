package es.felix.grifo_asto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoDetailDto {
    private Long idTurno;
    private Date fecha_entrada;
    private Date fecha_salida;
    private List<MedidaDto> medidas;
    private String observaciones;
    private Double sum;
    private Double rest;
}
