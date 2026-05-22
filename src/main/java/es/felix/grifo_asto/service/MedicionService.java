package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.dto.MedicionRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MedicionService {

    MedicionDto createMedicion(MedicionRequestDto medicionDto);
    MedicionDto updateMedicion(Long id, MedicionRequestDto medicionDto);
    Page<MedicionDto> getAllMedicion(Pageable pageable);
    void deleteMedicion(Long id);
}
