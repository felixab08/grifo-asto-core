package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.EntradaCombustibleDto;
import es.felix.grifo_asto.entity.EntradaCombustible;
import es.felix.grifo_asto.mapper.EntradaCombustibleMapper;
import es.felix.grifo_asto.repository.EntradaCombustibleRepository;
import es.felix.grifo_asto.service.EntradaCombustibleService;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;

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
    public org.springframework.data.domain.Page<EntradaCombustibleDto> getAllEntradasCombustible(org.springframework.data.domain.Pageable pageable) {
        org.springframework.data.domain.Page<EntradaCombustible> entradaCombustible =  entradaCombustibleRepository.findAll(pageable);
        return entradaCombustible.map(EntradaCombustibleMapper::mapToEntradaCombustibleDto);
    }
}
