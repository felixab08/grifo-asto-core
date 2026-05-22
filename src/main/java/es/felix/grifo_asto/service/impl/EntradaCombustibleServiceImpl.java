package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.EntradaCombustibleDto;
import es.felix.grifo_asto.entity.EntradaCombustible;
import es.felix.grifo_asto.exception.ResourceNotFoundException;
import es.felix.grifo_asto.mapper.EntradaCombustibleMapper;
import es.felix.grifo_asto.repository.EntradaCombustibleRepository;
import es.felix.grifo_asto.service.EntradaCombustibleService;
import lombok.AllArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public EntradaCombustibleDto updateEntradaCombustible(Long id, EntradaCombustibleDto entadaComDto) {
        EntradaCombustible entrada = entradaCombustibleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el dato"));
        entrada.setFechaEntrada(entadaComDto.getFechaEntrada());
        entrada.setCantidad(entadaComDto.getCantidad());
        entrada.setTipo(entadaComDto.getTipo());
        entrada.setPersona(entadaComDto.getPersona());
        return EntradaCombustibleMapper.mapToEntradaCombustibleDto(entradaCombustibleRepository.save(entrada));
    }

    @Override
    public Page<EntradaCombustibleDto> getAllEntradasCombustible(Pageable pageable) {
        Page<EntradaCombustible> entradaCombustible =  entradaCombustibleRepository.findAll(pageable);
        return entradaCombustible.map(EntradaCombustibleMapper::mapToEntradaCombustibleDto);
    }

    @Override
    public void deleteEntradaCombustible(Long id) {
        entradaCombustibleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el dato"));
        entradaCombustibleRepository.deleteById(id);
    }
}
