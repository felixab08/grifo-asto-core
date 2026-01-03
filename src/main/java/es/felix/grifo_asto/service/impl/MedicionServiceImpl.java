package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.dto.MedicionRequestDto;
import es.felix.grifo_asto.entity.Medicion;
import es.felix.grifo_asto.mapper.MedicionMapper;
import es.felix.grifo_asto.repository.MedicionRepository;
import es.felix.grifo_asto.service.MedicionService;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicionServiceImpl implements MedicionService {

    private MedicionRepository medicionRepository;

    @Override
    public MedicionDto createMedicion(MedicionRequestDto medicionDto) {
        Medicion medicion = MedicionMapper.mapToMedicion(medicionDto);
        Medicion saveMedicion = medicionRepository.save(medicion);
        return MedicionMapper.mapToMedicionDto(saveMedicion);
    }

    @Override
    public org.springframework.data.domain.Page<MedicionDto> getAllMedicion(org.springframework.data.domain.Pageable pageable) {
        org.springframework.data.domain.Page<Medicion> mediciones = medicionRepository.findAll(pageable);
        return mediciones.map(MedicionMapper::mapToMedicionDto);
    }
}
