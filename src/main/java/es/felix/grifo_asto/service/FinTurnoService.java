package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.FinTurnoDto;

import java.util.List;

public interface FinTurnoService {
    FinTurnoDto createFinTurno(FinTurnoDto finTurno);

    FinTurnoDto updateFinTurno(Long id, FinTurnoDto finTurnoDto);

    List<FinTurnoDto> listAllFinTurnos();
}
