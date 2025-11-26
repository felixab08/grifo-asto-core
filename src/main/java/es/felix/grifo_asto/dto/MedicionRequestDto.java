package es.felix.grifo_asto.dto;

import es.felix.grifo_asto.entity.Persona;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Getter
public class MedicionRequestDto {
    Persona idpersona;

    @NonNull
    Date fechaMedicion;
    String diesel;
    String regular;
    String premiun;
}

