package es.felix.grifo_asto.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import es.felix.grifo_asto.shared.PaginationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaTurnosDto {
    private Long idPersona;
    private String nombre;
    private String apellido;

    @JsonUnwrapped
    private PaginationResponse<TurnoDetailDto> turnos;
}
