package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.RegistroMedidorDto;
import es.felix.grifo_asto.entity.RegistroMedidor;

import java.util.List;

public interface RegistroMedidorService {
    RegistroMedidorDto crearRegistroMedidor(RegistroMedidorDto registroMedidorDto);

    List<RegistroMedidorDto> getAllRegistroMedidores();

}
