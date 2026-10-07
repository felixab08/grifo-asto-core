package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicionDto {
    Long idMedicion;
    Persona idpersona;
    LocalDateTime fechaMedicion;
    Double diesel;
    Double regular;
    Double premiun;
    
}
