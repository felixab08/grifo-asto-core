package es.felix.grifo_asto.security;

import es.felix.grifo_asto.entity.Persona;
import es.felix.grifo_asto.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonaRepository personaRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        log.debug("Cargando detalles del usuario");

        Persona persona = personaRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> {
                    log.warn("Intento de acceso con credenciales no encontradas");
                    return new UsernameNotFoundException("Usuario no encontrado");
                });

        log.debug("Usuario encontrado en la base de datos");
        return new CustomUserDetails(persona);
    }
}
