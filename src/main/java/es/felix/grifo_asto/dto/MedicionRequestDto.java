package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.Persona;
import lombok.Getter;
import lombok.NonNull;

import java.util.Date;


@Getter
public class MedicionRequestDto {
    Persona idpersona;

    @NonNull
    Date fechaMedicion;
    Double diesel;
    Double regular;
    Double premiun;
    String code;
}

