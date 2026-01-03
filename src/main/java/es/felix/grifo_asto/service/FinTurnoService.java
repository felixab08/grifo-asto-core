package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.FinTurnoDto;
import es.felix.grifo_asto.dto.FinTurnoResponse;

import java.util.List;

public interface FinTurnoService {
    FinTurnoDto createFinTurno(FinTurnoDto finTurno);

    FinTurnoDto updateFinTurno(Long id, FinTurnoDto finTurnoDto);

    List<FinTurnoDto> listAllFinTurnos();

    FinTurnoResponse getFinTurnosByPersona(Long idPersona, int size);

    org.springframework.data.domain.Page<FinTurnoDto> getAllFinTurnos(es.felix.grifo_asto.dto.request.turno.FinTurnoFilterDto filter, org.springframework.data.domain.Pageable pageable);
}
