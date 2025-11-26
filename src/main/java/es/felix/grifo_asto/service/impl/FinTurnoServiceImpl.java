package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.FinTurnoDto;
import es.felix.grifo_asto.entity.FinTurno;
import es.felix.grifo_asto.exception.ResourceNotFoundException;
import es.felix.grifo_asto.mapper.FinTurnoMapper;
import es.felix.grifo_asto.repository.FinTurnoRepository;
import es.felix.grifo_asto.service.FinTurnoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static es.felix.grifo_asto.config.Constants.NOT_FOUND_TURNO;

@Service
@AllArgsConstructor
public class FinTurnoServiceImpl implements FinTurnoService {
    private FinTurnoRepository finTurnoRepository;

    @Override
    public FinTurnoDto createFinTurno(FinTurnoDto finTurnoDto) {
        FinTurno finTurno = FinTurnoMapper.toFinTurno(finTurnoDto);
        return FinTurnoMapper.toFinTurnoDto(finTurnoRepository.save(finTurno));
    }

    @Override
    public FinTurnoDto updateFinTurno(Long id, FinTurnoDto finTurnoDto) {
        FinTurno finTurno = finTurnoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_TURNO + id));
        finTurno.setFechaSalida(finTurnoDto.getFechaSalida());
        finTurno.setObservaciones(finTurnoDto.getObservaciones());
        return FinTurnoMapper.toFinTurnoDto(finTurnoRepository.save(finTurno));
    }

    @Override
    public List<FinTurnoDto> listAllFinTurnos() {
        List<FinTurno> finTurnos = finTurnoRepository.findAll();
        return finTurnos.stream().map(FinTurnoMapper::toFinTurnoDto).toList();
    }
}
