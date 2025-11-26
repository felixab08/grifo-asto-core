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
                registroMedidor.getIdTurno()
        );
    }
    public static RegistroMedidor mapToRegistroMedidor(RegistroMedidorDto registroMedidor) {
        return  new RegistroMedidor(
                registroMedidor.getIdRegistro(),
                registroMedidor.getEntrada(),
                registroMedidor.getSalida(),
                registroMedidor.getTipo(),
                registroMedidor.getTurno()
        );
    }

    public static RegistroMedidorDto mapToRegistroMedidorDtoResponse(RegistroMedidor registroMedidor) {
        return  new RegistroMedidorDto(
                registroMedidor.getIdRegistro(),
                registroMedidor.getEntrada(),
                registroMedidor.getSalida(),
                registroMedidor.getTipo()
        );
    }
    public static RegistroMedidorRequestDto mapToRegistroMedidorDtoRequest(RegistroMedidor registroMedidor) {
        return  new RegistroMedidorRequestDto(
                registroMedidor.getIdTurno(),
                registroMedidor.getEntrada(),
                registroMedidor.getTipo()
        );
    }
}
