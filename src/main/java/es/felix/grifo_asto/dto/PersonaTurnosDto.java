package es.felix.grifo_asto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaTurnosDto {
    private Long idPersona;
    private String nombre;
    private String apellido;
    private List<TurnoDetailDto> turnos;
}
