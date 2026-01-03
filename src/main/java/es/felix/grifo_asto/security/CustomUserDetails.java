package es.felix.grifo_asto.security;

import es.felix.grifo_asto.entity.Persona;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Implementación personalizada de UserDetails de Spring Security
 * que adapta la entidad Persona al sistema de seguridad
 */
@Getter
@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final Persona persona;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_" + persona.getRole().name())
        );
    }

    @Override
    public String getPassword() {
        return persona.getPassword();
    }

    @Override
    public String getUsername() {
        return persona.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return persona.getActivo();
    }
}
