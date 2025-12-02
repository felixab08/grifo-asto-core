package es.felix.grifo_asto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedidaDto {
    private Long idMedida;
    private Long idTurno;
    private String tipo;
    private Double entrada;
    private Double salida;
    private String code;
}
