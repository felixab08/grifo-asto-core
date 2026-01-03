package es.felix.grifo_asto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

    @JsonProperty("access_token")
    private String token;

    @Builder.Default
    @JsonProperty("token_type")
    private String type = "Bearer";

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String username;
    private String role;

    /**
     * Constructor sin tipo de token (por defecto será "Bearer")
     */
    public LoginResponseDto(String token, Long id, String nombre, String apellido,
                            String telefono, String email, String username, String role) {
        this.token = token;
        this.type = "Bearer";
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.username = username;
        this.role = role;
    }
}
