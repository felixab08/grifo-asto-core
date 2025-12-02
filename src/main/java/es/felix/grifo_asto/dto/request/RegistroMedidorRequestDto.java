package es.felix.grifo_asto.dto.request;

import es.felix.grifo_asto.entity.FinTurno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroMedidorRequestDto {

    Long idRegistro;
    Double entrada;
    Double salida;
    String tipo;
    Long idTurno;
    String code;

    public RegistroMedidorRequestDto(FinTurno idTurno, Double entrada, String tipo, String code) {
        this.entrada = entrada;
        this.tipo = tipo;
        this.idTurno = idTurno.getIdTurno();
        this.code = code;
    }
}
