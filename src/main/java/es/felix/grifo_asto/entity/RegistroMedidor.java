package es.felix.grifo_asto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registro_medidor")
public class RegistroMedidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_register")
    private Long idRegistro;

    @Column(name="entrada", nullable = false)
    private Double entrada;

    @Column(name="salida" )
    private Double salida;

    @Column(name="tipo", nullable = false, length = 50)
    private String tipo;

    @ManyToOne
    @JoinColumn(name="id_persona", referencedColumnName = "idPersona")
    private Persona persona;

    public RegistroMedidor(Long idRegistro, Double entrada, Double salida, String tipo) {
        this.idRegistro = idRegistro;
        this.entrada = entrada;
        this.salida = salida;
        this.tipo = tipo;
    }
}
