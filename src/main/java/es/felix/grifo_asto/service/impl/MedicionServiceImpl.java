package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.entity.Medicion;
import es.felix.grifo_asto.mapper.MedicionMapper;
import es.felix.grifo_asto.repository.MedicionRepository;
import es.felix.grifo_asto.service.MedicionService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicionServiceImpl implements MedicionService {
    private MedicionRepository medicionRepository;
    private static final Logger log = LoggerFactory.getLogger(MedicionServiceImpl.class);
    @Override
    public MedicionDto createMedicion(MedicionDto medicionDto) {
        Medicion medicion = MedicionMapper.mapToMedicion(medicionDto);
        Medicion saveMedicion = medicionRepository.save(medicion);
        return MedicionMapper.mapToMedicionDto(saveMedicion);
    }

    @Override
    public List<MedicionDto> getAllMedicion() {
        List<Medicion> mediciones = medicionRepository.findAll();
        log.info("Valor procesado: {}", mediciones);
        return mediciones.stream().map((Medicion medicion)-> MedicionMapper.mapToMedicionDto(medicion)).collect(Collectors.toList());
    }
}
