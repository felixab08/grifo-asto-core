package es.felix.grifo_asto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
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

    @Column(name = "email", unique = true, nullable = false, length = 150)
    private String email;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private Role role;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @Column(
            name = "fecha_create",
            updatable = false,
            insertable = false,   // 👈 IMPORTANTE
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    @CreationTimestamp
    private Date fechaCreate;

    public Persona(Long idPersona, String nombre, String apellido, String telefono, Date fechaCreate) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaCreate = fechaCreate;
    }

}
