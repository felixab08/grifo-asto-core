package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.RegistroMedidorDto;
import es.felix.grifo_asto.entity.RegistroMedidor;
import es.felix.grifo_asto.mapper.RegistroMedidorMapper;
import es.felix.grifo_asto.repository.RegistroMedidorRepository;
import es.felix.grifo_asto.service.RegistroMedidorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegistroMedidorServiceImpl implements RegistroMedidorService {

    private RegistroMedidorRepository registroMedidorRepository;

    @Override
    public RegistroMedidorDto crearRegistroMedidor(RegistroMedidorDto registroMedidorDto) {
        RegistroMedidor registroMedidor = RegistroMedidorMapper.mapToRegistroMedidor(registroMedidorDto);
        return RegistroMedidorMapper.mapToRegistroMedidorDtoResponse(registroMedidorRepository.save(registroMedidor));
    }

    @Override
    public List<RegistroMedidorDto> getAllRegistroMedidores() {
        List<RegistroMedidor>  registroMedidores = registroMedidorRepository.findAll();
        return registroMedidores.stream().map((registro)-> RegistroMedidorMapper.mapToRegistroMedidorDtoResponse(registro)).collect(Collectors.toList());
    }
}
