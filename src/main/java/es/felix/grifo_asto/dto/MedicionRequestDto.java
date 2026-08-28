package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.Persona;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;


@Getter
public class MedicionRequestDto {
    Persona idpersona;

    @NonNull
    LocalDate fechaMedicion;
    Double diesel;
    Double regular;
    Double premiun;
    String code;
}

