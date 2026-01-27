package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.DetalleVentaDto;
import es.felix.grifo_asto.dto.filter.FilterDto;
import es.felix.grifo_asto.entity.DetalleVenta;
import es.felix.grifo_asto.exception.ResourceNotFoundException;
import es.felix.grifo_asto.mapper.DetalleVentaMapper;
import es.felix.grifo_asto.repository.DetalleVentaRepository;
import es.felix.grifo_asto.service.DetalleVentaService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;

import static es.felix.grifo_asto.config.Constants.NOT_FOUND_VENTA_DETALLE;

@Service
@AllArgsConstructor
public class DetalleVentaServiceImpl implements DetalleVentaService {

    private DetalleVentaRepository detalleVentaRepository;
    private static final Logger log = LoggerFactory.getLogger(DetalleVentaServiceImpl.class);

    @Override
    public DetalleVentaDto createDetalleVenta(DetalleVentaDto dto) {
        log.info("dto<<<<<crear {}", dto);

        DetalleVenta detalleVenta = DetalleVentaMapper.mapToDetalleVenta(dto);

        DetalleVenta detalleVentaSave = detalleVentaRepository.save(detalleVenta);

        return DetalleVentaMapper.mapToDetalleVentaDto(detalleVentaSave);
    }

    @Override
    public DetalleVentaDto updateDetalleVenta(Long id, DetalleVentaDto dto) {
        DetalleVenta detalleVenta = detalleVentaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_VENTA_DETALLE + id) );
        detalleVenta.setNumVale( dto.getNumVale());
        detalleVenta.setPersona( dto.getPersona());
        detalleVenta.setArea( dto.getArea());
        detalleVenta.setPlaca( dto.getPlaca());
        detalleVenta.setFechaVenta( dto.getFechaVenta());
        detalleVenta.setDiesel( dto.getDiesel());
        detalleVenta.setRegular( dto.getRegular());
        detalleVenta.setPremiun( dto.getPremiun());
        return DetalleVentaMapper.mapToDetalleVentaDto(detalleVentaRepository.save(detalleVenta));
    }

    @Override
    public Page<DetalleVentaDto> getDetalleVenta(FilterDto filterDto, Pageable pageable) {
        LocalDate start = filterDto.getStartDate() != null
                ? filterDto.getStartDate()
                : LocalDate.of(2026, 1, 1);

        LocalDate end = filterDto.getEndDate() != null
                ? filterDto.getEndDate()
                : LocalDate.now();
        var detalleVenta = detalleVentaRepository.findByFilters(filterDto.getId(), start, end, pageable);
        return detalleVenta.map(DetalleVentaMapper::mapToDetalleVentaDto);
    }

    @Override
    public void deleteDetalleVenta(Long id) {
        detalleVentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_VENTA_DETALLE + id));
        detalleVentaRepository.deleteById(id);
    }
}
