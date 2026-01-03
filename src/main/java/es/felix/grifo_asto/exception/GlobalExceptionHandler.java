package es.felix.grifo_asto.exception;

import es.felix.grifo_asto.controller.convert.GeneralResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GeneralResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        log.warn("Recurso no encontrado: {}", ex.getMessage());

        GeneralResponse<Object> response = GeneralResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<GeneralResponse<Object>> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        log.warn("Credenciales inválidas: {}", ex.getMessage());

        GeneralResponse<Object> response = GeneralResponse.builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .message(ex.getMessage())
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(JwtAuthenticationException.class)
    public ResponseEntity<GeneralResponse<Object>> handleJwtAuthenticationException(JwtAuthenticationException ex) {
        log.warn("Error de autenticación JWT: {}", ex.getMessage());

        GeneralResponse<Object> response = GeneralResponse.builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .message(ex.getMessage())
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<GeneralResponse<Object>> handleAccessDeniedException(AccessDeniedException ex) {
        log.warn("Acceso denegado: {}", ex.getMessage());

        GeneralResponse<Object> response = GeneralResponse.builder()
                .code(HttpStatus.FORBIDDEN.value())
                .message("Acceso denegado: no tiene permisos suficientes")
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GeneralResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.warn("Errores de validación en la petición");

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        GeneralResponse<Map<String, String>> response = GeneralResponse.<Map<String, String>>builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Errores de validación")
                .data(errors)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralResponse<Object>> handleGlobalException(Exception ex) {
        // Log completo del error para debugging, pero no exponemos detalles al cliente
        log.error("Error interno del servidor", ex);

        GeneralResponse<Object> response = GeneralResponse.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Error interno del servidor. Por favor, contacte al administrador.")
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
