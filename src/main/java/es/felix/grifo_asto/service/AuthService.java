package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.LoginRequestDto;
import es.felix.grifo_asto.dto.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
