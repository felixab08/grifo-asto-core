package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.FinTurnoDto;
import es.felix.grifo_asto.entity.FinTurno;

public class FinTurnoMapper {
    public static FinTurnoDto toFinTurnoDto(FinTurno finTurno) {
    FinTurnoDto dto = new FinTurnoDto();
                dto.setIdTurno(finTurno.getIdTurno());
                dto.setObservaciones(finTurno.getObservaciones());
                dto.setFechaEntrada(finTurno.getFechaEntrada());
                dto.setFechaSalida(finTurno.getFechaSalida());
                dto.setPersona(finTurno.getPersona());
                dto.setSum(finTurno.getSum());
                dto.setRest(finTurno.getRest());
        return dto;
    }

    public static FinTurno toFinTurno(FinTurnoDto finTurno) {
        FinTurno fint =  new FinTurno();
                fint.setIdTurno(finTurno.getIdTurno());
                fint.setObservaciones(finTurno.getObservaciones());
                fint.setFechaEntrada(finTurno.getFechaEntrada());
                fint.setFechaSalida(finTurno.getFechaSalida());
                fint.setSum(finTurno.getSum());
                fint.setRest(finTurno.getRest());
                fint.setPersona(finTurno.getPersona());
        return fint;
    }
}
