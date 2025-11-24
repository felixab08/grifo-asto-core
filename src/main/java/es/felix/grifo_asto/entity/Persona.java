package es.felix.grifo_asto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @Column(name = "nombre",nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido",nullable = false, length = 100)
    private String apellido;

    @Column(name = "telefono",nullable = false, length = 9)
    private String telefono;


    @Column(
            name = "fecha_create",
            updatable = false,
            insertable = false,   // 👈 IMPORTANTE
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreate;


}
