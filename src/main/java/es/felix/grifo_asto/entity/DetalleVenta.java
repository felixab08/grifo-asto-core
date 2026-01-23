package es.felix.grifo_asto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private Long idDetalleVenta;

    @Column(name="num_vale", nullable = false, length = 50)
    private String numVale;

    @Column(name="persona", nullable = false, length = 50)
    private String persona;

    @Column(name="placa", nullable = false, length = 50)
    private String placa;

    @Column(name="area", nullable = false, length = 50)
    private String area;

    @Column(name = "fecha_venta",nullable = false)
    private LocalDate fechaVenta;

    @Column(name = "diesel")
    private Double diesel;

    @Column(name = "regular")
    private Double regular;

    @Column(name = "premiun")
    private Double premiun;

    @ManyToOne
    @JoinColumn(name="id_tipo_venta", referencedColumnName = "id_tipo_venta")
    private TipoVenta tipoVenta;
}
