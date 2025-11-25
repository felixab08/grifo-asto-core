package es.felix.grifo_asto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entrada_combustible")
public class EntradaCombustible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada")
    private Long idEntrada;

    @Column(name="tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name="cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "fecha_entrada",updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date fechaEntrada;

    @ManyToOne
    @JoinColumn(name="id_persona", referencedColumnName = "idPersona")
    private Persona persona;

    public EntradaCombustible(Long idEntrada, String tipo, Integer cantidad, Date fechaEntrada) {
        this.idEntrada = idEntrada;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fechaEntrada = fechaEntrada;
    }
}
