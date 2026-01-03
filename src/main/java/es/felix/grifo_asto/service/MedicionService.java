package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.dto.MedicionRequestDto;



public interface MedicionService {

    MedicionDto createMedicion(MedicionRequestDto medicionDto);


    org.springframework.data.domain.Page<MedicionDto> getAllMedicion(org.springframework.data.domain.Pageable pageable);
}
