package es.felix.grifo_asto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_organization")
    private Long idOrganization;

    @Column(name="nombre_organization", nullable = false, length = 250)
    private String nombreOrganization;

    @Column(name="status")
    private Boolean status;

    @Column(name="ruc")
    private String ruc;
}
