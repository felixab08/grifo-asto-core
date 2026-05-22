package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.dto.MedicionRequestDto;
import es.felix.grifo_asto.entity.Medicion;
import es.felix.grifo_asto.mapper.MedicionMapper;
import es.felix.grifo_asto.repository.MedicionRepository;
import es.felix.grifo_asto.service.MedicionService;
import lombok.AllArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public MedicionDto updateMedicion(Long id, MedicionRequestDto medicionDto) {
        Medicion medicion = medicionRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicion no encontrado"));
        medicion.setFechaMedicion(medicionDto.getFechaMedicion());
        medicion.setDiesel(medicionDto.getDiesel());
        medicion.setRegular(medicionDto.getRegular());
        medicion.setPremiun(medicionDto.getPremiun());
        medicion.setIdPersona(medicionDto.getIdpersona());
        return MedicionMapper.mapToMedicionDto(medicionRepository.save(medicion));
    }

    @Override
    public Page<MedicionDto> getAllMedicion(Pageable pageable) {
        Page<Medicion> mediciones = medicionRepository.findAll(pageable);
        return mediciones.map(MedicionMapper::mapToMedicionDto);
    }

    @Override
    public void deleteMedicion(Long id) {
        medicionRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicion no encontrado"));
        medicionRepository.deleteById(id);
    }
}
