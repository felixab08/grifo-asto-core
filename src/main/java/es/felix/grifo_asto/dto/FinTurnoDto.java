package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinTurnoDto {
    Long idTurno;
    String observaciones;
    LocalDate fechaEntrada;
    LocalDate fechaSalida;
    Persona persona;
    Double sum;
    Double rest;
}
