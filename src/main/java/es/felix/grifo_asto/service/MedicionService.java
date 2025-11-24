package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.MedicionDto;

import java.util.List;

public interface MedicionService {
    MedicionDto createMedicion(MedicionDto medicionDto);
    List<MedicionDto> getAllMedicion();
}
