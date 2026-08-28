package es.felix.grifo_asto.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

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

   @ManyToOne
//   @JoinColumn(name = "medicion", nullable = false, foreignKey = @ForeignKey(name = "fk_medicion_tanque_persona"))
   @JoinColumn(name = "idpersona", nullable = false)
    private Persona idPersona;

    @Column(name = "fecha_medicion", updatable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @CreationTimestamp
    private LocalDate fechaMedicion;

    @Column(name = "diesel")
    private Double diesel;

    @Column(name = "regular")
    private Double regular;



    @Column(name = "premiun")
    private Double premiun;

    public Medicion(Persona idPersona, LocalDate fechaMedicion, Double diesel, Double regular, Double premiun) {
        this.idPersona = idPersona;
        this.fechaMedicion = fechaMedicion;
        this.diesel = diesel;
        this.regular = regular;
        this.premiun = premiun;
    }
}
