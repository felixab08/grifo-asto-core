package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicionDto {
     Long idMedicion;
    Persona idpersona;
    Date fechaMedicion;
    String diesel;
    String regular;
    String premiun;
}
