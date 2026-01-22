package es.felix.grifo_asto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_venta")
public class TipoVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_venta")
    private Long idTipoVenta;

    @Column(name="tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name="codigo", nullable = false)
    private String codigo;

    @Column(name="status", nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="id_organization", referencedColumnName = "id_organization")
    private Organization organization;
}
