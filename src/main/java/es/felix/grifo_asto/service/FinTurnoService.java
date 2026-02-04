package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.FinTurnoDto;
import es.felix.grifo_asto.dto.FinTurnoResponse;
import es.felix.grifo_asto.dto.ReporteFinTurnoResponse;
import es.felix.grifo_asto.dto.request.turno.FinTurnoFilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FinTurnoService {
    FinTurnoDto createFinTurno(FinTurnoDto finTurno);

    FinTurnoDto updateFinTurno(Long id, FinTurnoDto finTurnoDto);

    List<FinTurnoDto> listAllFinTurnos();

    ReporteFinTurnoResponse ReporteAllFinTurnos(int year);

    FinTurnoResponse getFinTurnosByPersona(Long idPersona, int size);

    Page<FinTurnoDto> getAllFinTurnos(FinTurnoFilterDto filter, Pageable pageable);
}
