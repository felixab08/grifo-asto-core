package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.config.Constants;
import es.felix.grifo_asto.dto.LoginRequestDto;
import es.felix.grifo_asto.dto.LoginResponseDto;
import es.felix.grifo_asto.entity.Persona;
import es.felix.grifo_asto.exception.InvalidCredentialsException;
import es.felix.grifo_asto.security.CustomUserDetails;
import es.felix.grifo_asto.security.JwtTokenProvider;
import es.felix.grifo_asto.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        try {
            log.debug("Iniciando proceso de autenticación");

            // Autenticar al usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestDto.getUsernameOrEmail(),
                            loginRequestDto.getPassword()
                    )
            );

            // Establecer el contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Generar token JWT
            String token = tokenProvider.generateToken(authentication);

            // Obtener los detalles del usuario desde el objeto de autenticación
            // Esto evita una query adicional a la base de datos
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            Persona persona = userDetails.getPersona();

            log.info("Autenticación exitosa para el usuario con ID: {}", persona.getIdPersona());

            return new LoginResponseDto(
                    token,
                    persona.getIdPersona(),
                    persona.getNombre(),
                    persona.getApellido(),
                    persona.getTelefono(),
                    persona.getEmail(),
                    persona.getUsername(),
                    persona.getRole().name()
            );

        } catch (BadCredentialsException e) {
            log.warn("Intento de autenticación fallido: credenciales inválidas");
            throw new InvalidCredentialsException(Constants.INVALID_CREDENTIALS);
        } catch (Exception e) {
            log.error("Error inesperado durante la autenticación: {}", e.getMessage());
            throw new InvalidCredentialsException(Constants.INVALID_CREDENTIALS);
        }
    }
}
