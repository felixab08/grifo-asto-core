package es.felix.grifo_asto.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "turno")
public class FinTurno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Long idTurno;

    @Column(name="observaciones", length = 250)
    private String observaciones;

    @Column(name = "fecha_entrada", updatable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate fechaEntrada;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "rest")
    private Double rest;

    @ManyToOne
    @JoinColumn(name="id_persona", referencedColumnName = "idPersona")
    private Persona persona;

}
