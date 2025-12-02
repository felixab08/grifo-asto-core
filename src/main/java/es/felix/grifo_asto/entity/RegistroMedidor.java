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

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name="id_turno", referencedColumnName = "id_turno")
    private FinTurno idTurno;

    public RegistroMedidor(Long idRegistro2, Double entrada2, Double salida2, String tipo2, String code2) {
        this.idRegistro = idRegistro2;
        this.entrada = entrada2;
        this.salida = salida2;
        this.tipo = tipo2;
        this.code = code2;
    }
}
