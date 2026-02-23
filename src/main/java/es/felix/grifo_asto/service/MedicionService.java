package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.dto.MedicionRequestDto;
import org.springframework.data.domain.Pageable;


public interface MedicionService {

    MedicionDto createMedicion(MedicionRequestDto medicionDto);


    org.springframework.data.domain.Page<MedicionDto> getAllMedicion(Pageable pageable);
}
