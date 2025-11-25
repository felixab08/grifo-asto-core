package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.EntradaCombustibleDto;
import es.felix.grifo_asto.entity.EntradaCombustible;
import es.felix.grifo_asto.mapper.EntradaCombustibleMapper;
import es.felix.grifo_asto.repository.EntradaCombustibleRepository;
import es.felix.grifo_asto.service.EntradaCombustibleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EntradaCombustibleServiceImpl implements EntradaCombustibleService {

    private EntradaCombustibleRepository entradaCombustibleRepository;

    @Override
    public EntradaCombustibleDto crearEntradaCombustible(EntradaCombustibleDto entadaCombustibleDto) {
        EntradaCombustible entradaCombustible = EntradaCombustibleMapper.mapToEntradaCombustible(entadaCombustibleDto);
        return EntradaCombustibleMapper.mapToEntradaCombustibleDto(entradaCombustibleRepository.save(entradaCombustible));
    }

    @Override
    public List<EntradaCombustibleDto> getAllEntradasCombustible() {
         List<EntradaCombustible> entradaCombustible =  entradaCombustibleRepository.findAll();
        return entradaCombustible.stream().map((entrada) -> EntradaCombustibleMapper.mapToEntradaCombustibleDto(entrada)).collect(Collectors.toList());
    }
}
