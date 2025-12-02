package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.dto.MedicionRequestDto;
import es.felix.grifo_asto.entity.Medicion;
import es.felix.grifo_asto.mapper.MedicionMapper;
import es.felix.grifo_asto.repository.MedicionRepository;
import es.felix.grifo_asto.service.MedicionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<MedicionDto> getAllMedicion() {
        List<Medicion> mediciones = medicionRepository.findAll();
        return mediciones.stream().map((Medicion medicion)-> MedicionMapper.mapToMedicionDto(medicion)).collect(Collectors.toList());
    }
}
