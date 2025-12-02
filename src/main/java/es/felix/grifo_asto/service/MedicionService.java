package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.dto.MedicionRequestDto;

import java.util.List;

public interface MedicionService {

    MedicionDto createMedicion(MedicionRequestDto medicionDto);


    List<MedicionDto> getAllMedicion(Integer cantidad);
}
