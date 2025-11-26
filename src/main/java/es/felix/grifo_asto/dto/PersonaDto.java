package es.felix.grifo_asto.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String telefono;
    private Date fechaCreate;
}
