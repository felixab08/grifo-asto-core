package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.*;
import es.felix.grifo_asto.entity.FinTurno;
import es.felix.grifo_asto.entity.Persona;
import es.felix.grifo_asto.entity.RegistroMedidor;
import es.felix.grifo_asto.exception.ResourceNotFoundException;
import es.felix.grifo_asto.mapper.FinTurnoMapper;
import es.felix.grifo_asto.repository.FinTurnoRepository;
import es.felix.grifo_asto.repository.PersonaRepository;
import es.felix.grifo_asto.repository.RegistroMedidorRepository;
import es.felix.grifo_asto.service.FinTurnoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static es.felix.grifo_asto.config.Constants.NOT_FOUND_TURNO;

@Service
@AllArgsConstructor
public class FinTurnoServiceImpl implements FinTurnoService {
    private FinTurnoRepository finTurnoRepository;
    private PersonaRepository personaRepository;
    private RegistroMedidorRepository registroMedidorRepository;

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

    @Override
    public FinTurnoResponse getFinTurnosByPersona(Long idPersona) {
        Persona persona = personaRepository.findById(idPersona)
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada con id: " + idPersona));

        List<FinTurno> turnos = finTurnoRepository.findTop20ByPersona_IdPersonaOrderByFechaEntradaDesc(idPersona);

        List<TurnoDetailDto> turnoDetails = turnos.stream().map(turno -> {
            List<RegistroMedidor> medidas = registroMedidorRepository.findByIdTurno_IdTurno(turno.getIdTurno());
            
            List<MedidaDto> medidaDtos = medidas.stream()
                    .sorted(Comparator.comparing((RegistroMedidor m) -> {
                        String code = m.getCode();
                        if (code.contains("pet11")) return 1;
                        if (code.contains("pet21")) return 2;
                        if (code.contains("reg12")) return 3;
                        if (code.contains("reg22")) return 4;
                        if (code.contains("pri13")) return 5;
                        if (code.contains("pri23")) return 6;
                        return 7;
                    }))
                    .map(m -> new MedidaDto(
                            m.getIdRegistro(),
                            m.getIdTurno().getIdTurno(),
                            m.getTipo(),
                            m.getEntrada(),
                            m.getSalida(),
                            m.getCode()
                    ))
                    .collect(Collectors.toList());

            return new TurnoDetailDto(
                    turno.getIdTurno(),
                    turno.getFechaEntrada(),
                    turno.getFechaSalida(),
                    medidaDtos,
                    turno.getObservaciones()
            );
        }).collect(Collectors.toList());

        PersonaTurnosDto personaTurnosDto = new PersonaTurnosDto(
                persona.getIdPersona(),
                persona.getNombre(),
                persona.getApellido(),
                turnoDetails
        );

        return new FinTurnoResponse(
                "Lista de cierres de atencion de una persona",
                200,
                List.of(personaTurnosDto)
        );
    }
}
