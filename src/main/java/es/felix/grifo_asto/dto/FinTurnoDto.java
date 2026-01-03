package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinTurnoDto {
    Long idTurno;
    String observaciones;
    Date fechaEntrada;
    Date fechaSalida;
    Persona persona;
}
