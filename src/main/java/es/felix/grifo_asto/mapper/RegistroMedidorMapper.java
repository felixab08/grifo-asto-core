package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.RegistroMedidorDto;
import es.felix.grifo_asto.dto.request.RegistroMedidorRequestDto;
import es.felix.grifo_asto.entity.RegistroMedidor;

public class RegistroMedidorMapper {

    public static RegistroMedidorDto mapToRegistroDto(RegistroMedidor registroMedidor) {
        return new RegistroMedidorDto(
                registroMedidor.getIdRegistro(),
                registroMedidor.getEntrada(),
                registroMedidor.getSalida(),
                registroMedidor.getTipo(),
                registroMedidor.getIdTurno(),
                registroMedidor.getCode()
        );
    }
    public static RegistroMedidor mapToRegistroMedidor(RegistroMedidorDto registroMedidor) {
        RegistroMedidor entity = new RegistroMedidor(
                registroMedidor.getIdRegistro(),
                registroMedidor.getEntrada(),
                registroMedidor.getSalida(),
                registroMedidor.getTipo(),
                registroMedidor.getCode()
        );
        entity.setIdTurno(registroMedidor.getTurno());
        return entity;
    }

    public static RegistroMedidorDto mapToRegistroMedidorDtoResponse(RegistroMedidor registroMedidor) {
        return  new RegistroMedidorDto(
                registroMedidor.getIdRegistro(),
                registroMedidor.getEntrada(),
                registroMedidor.getSalida(),
                registroMedidor.getTipo(),
                registroMedidor.getCode()
        );
    }
    public static RegistroMedidorRequestDto mapToRegistroMedidorDtoRequest(RegistroMedidor registroMedidor) {
        return  new RegistroMedidorRequestDto(
                registroMedidor.getIdTurno(),
                registroMedidor.getEntrada(),
                registroMedidor.getTipo(),
                registroMedidor.getCode()
        );
    }
}
