package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.FinTurnoDto;
import es.felix.grifo_asto.entity.FinTurno;

public class FinTurnoMapper {
    public static FinTurnoDto toFinTurnoDto(FinTurno finTurno) {
        return new FinTurnoDto(
                finTurno.getIdTurno(),
                finTurno.getObservaciones(),
                finTurno.getFechaEntrada(),
                finTurno.getFechaSalida(),
                finTurno.getPersona(),
                finTurno.getSum(),
                finTurno.getRest()
        );
    }

    public static FinTurno toFinTurno(FinTurnoDto finTurno) {
        return new FinTurno(
                finTurno.getIdTurno(),
                finTurno.getObservaciones(),
                finTurno.getFechaEntrada(),
                finTurno.getFechaSalida(),
                finTurno.getSum(),
                finTurno.getRest(),
                finTurno.getPersona()
        );
    }
}
