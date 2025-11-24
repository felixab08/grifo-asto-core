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
@Table(name = "medicion_tanque")
public class Medicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicion;

    @Column(name = "id_persona", nullable = false)
    private Long idPersona;

    @Column(name = "fecha_medicion",updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMedicion;

    @Column(name = "diesel")
    private String diesel;

    @Column(name = "regular")
    private String regular;

    @Column(name = "premiun")
    private String premiun;
}
