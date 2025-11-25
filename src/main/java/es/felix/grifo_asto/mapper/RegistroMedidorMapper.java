package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.RegistroMedidorDto;
import es.felix.grifo_asto.entity.RegistroMedidor;

public class RegistroMedidorMapper {

    public static RegistroMedidorDto mapToRegistroDto(RegistroMedidor registroMedidor) {
        return  new RegistroMedidorDto(
                registroMedidor.getIdRegistro(),
                registroMedidor.getEntrada(),
                registroMedidor.getSalida(),
                registroMedidor.getTipo(),
                registroMedidor.getPersona()
        );
    }
    public static RegistroMedidor mapToRegistroMedidor(RegistroMedidorDto registroMedidor) {
        return  new RegistroMedidor(
                registroMedidor.getIdRegistro(),
                registroMedidor.getEntrada(),
                registroMedidor.getSalida(),
                registroMedidor.getTipo(),
                registroMedidor.getPersona()
        );
    }
}
