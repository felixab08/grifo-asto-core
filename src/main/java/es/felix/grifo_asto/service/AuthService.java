package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.LoginRequestDto;
import es.felix.grifo_asto.dto.LoginResponseDto;
import es.felix.grifo_asto.dto.RegisterRequestDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
    LoginResponseDto register(RegisterRequestDto registerRequestDto);
}
