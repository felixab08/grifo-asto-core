package es.felix.grifo_asto.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

    @NotBlank(message = "El usuario es requerido")
    private String usernameOrEmail;

    @NotBlank(message = "La contraseña es requerida")
    private String password;
}
