package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.RegistroMedidorDto;

import java.util.List;

public interface RegistroMedidorService {
    RegistroMedidorDto crearRegistroMedidor(RegistroMedidorDto registroMedidorDto);

    RegistroMedidorDto updateRegistroMedidor(Long id, RegistroMedidorDto registroMedidorDto);

    List<RegistroMedidorDto> getAllRegistroMedidores();

}
