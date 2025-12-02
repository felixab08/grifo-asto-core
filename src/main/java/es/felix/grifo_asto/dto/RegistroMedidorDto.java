package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.FinTurno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroMedidorDto {

    Long idRegistro;
    Double entrada;
    Double salida;
    String tipo;
    FinTurno turno;
    String code;
    

    public RegistroMedidorDto(Long idRegistro, Double entrada, Double salida, String tipo, String code) {
        this.idRegistro = idRegistro;
        this.entrada = entrada;
        this.salida = salida;
        this.tipo = tipo;
        this.code = code;
    }
}
