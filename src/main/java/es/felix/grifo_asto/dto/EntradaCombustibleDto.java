package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaCombustibleDto {
    Long idEntrada;
    String tipo;
    Integer cantidad;
    LocalDate fechaEntrada;
    Persona persona;
}
