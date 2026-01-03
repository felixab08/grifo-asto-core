package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.controller.convert.GeneralResponse;
import es.felix.grifo_asto.dto.LoginRequestDto;
import es.felix.grifo_asto.dto.LoginResponseDto;
import es.felix.grifo_asto.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<GeneralResponse<LoginResponseDto>> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        log.debug("Intento de autenticación recibido");

        LoginResponseDto loginResponse = authService.login(loginRequestDto);

        GeneralResponse<LoginResponseDto> response = GeneralResponse.<LoginResponseDto>builder()
                .code(HttpStatus.OK.value())
                .message("Login exitoso")
                .data(loginResponse)
                .build();

        log.info("Usuario autenticado exitosamente");
        return ResponseEntity.ok(response);
    }
}
