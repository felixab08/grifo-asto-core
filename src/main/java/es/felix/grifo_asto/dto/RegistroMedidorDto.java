package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.FinTurno;
import es.felix.grifo_asto.entity.Persona;
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

    public RegistroMedidorDto(Long idRegistro, Double entrada, Double salida, String tipo) {
        this.idRegistro = idRegistro;
        this.entrada = entrada;
        this.salida = salida;
        this.tipo = tipo;
    }

    public RegistroMedidorDto(Double entrada, String tipo, FinTurno turno) {
        this.entrada = entrada;
        this.tipo = tipo;
        this.turno = turno;
    }

    public RegistroMedidorDto(FinTurno turno, String tipo, Double entrada) {
        this.turno = turno;
        this.tipo = tipo;
        this.entrada = entrada;
    }
}
