package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.Persona;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;


@Getter
public class MedicionRequestDto {
    Persona idpersona;

    @NonNull
    LocalDateTime fechaMedicion;
    Double diesel;
    Double regular;
    Double premiun;
    String code;
}

