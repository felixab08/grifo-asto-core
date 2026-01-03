package es.felix.grifo_asto.security;

import es.felix.grifo_asto.exception.JwtAuthenticationException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    private final String jwtSecret;
    private final long jwtExpirationInMs;
    private final SecretKey signingKey;

    public JwtTokenProvider(
            @Value("${jwt.secret}") String jwtSecret,
            @Value("${jwt.expiration}") long jwtExpirationInMs
    ) {
        this.jwtSecret = jwtSecret;
        this.jwtExpirationInMs = jwtExpirationInMs;
        this.signingKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    /**
     * Genera un token JWT para el usuario autenticado
     */
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationInMs);

        String token = Jwts.builder()
                .subject(username)
                .issuedAt(currentDate)
                .expiration(expireDate)
                .signWith(signingKey)
                .compact();

        log.debug("Token JWT generado para el usuario");
        return token;
    }

    /**
     * Extrae el username del token JWT
     */
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(signingKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    /**
     * Valida el token JWT y lanza excepciones específicas si es inválido
     * @throws JwtAuthenticationException si el token es inválido, expirado, no soportado o vacío
     */
    public void validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(signingKey)
                    .build()
                    .parseSignedClaims(token);
            log.debug("Token JWT validado exitosamente");
        } catch (MalformedJwtException ex) {
            log.error("Token JWT inválido: {}", ex.getMessage());
            throw new JwtAuthenticationException("Token JWT inválido");
        } catch (ExpiredJwtException ex) {
            log.warn("Token JWT expirado: {}", ex.getMessage());
            throw new JwtAuthenticationException("Token JWT expirado");
        } catch (UnsupportedJwtException ex) {
            log.error("Token JWT no soportado: {}", ex.getMessage());
            throw new JwtAuthenticationException("Token JWT no soportado");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string está vacío: {}", ex.getMessage());
            throw new JwtAuthenticationException("JWT claims string está vacío");
        }
    }
}
