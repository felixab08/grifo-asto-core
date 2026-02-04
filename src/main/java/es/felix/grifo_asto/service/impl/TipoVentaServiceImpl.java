package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.TipoVentaDto;
import es.felix.grifo_asto.dto.filter.FilterDto;
import es.felix.grifo_asto.entity.TipoVenta;
import es.felix.grifo_asto.exception.ResourceNotFoundException;
import es.felix.grifo_asto.mapper.TipoVentaMapper;
import es.felix.grifo_asto.repository.TipoVentaRepository;
import es.felix.grifo_asto.service.TipoVentaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import static es.felix.grifo_asto.config.Constants.NOT_FOUND_TIPO_VENTA;

@Service
@AllArgsConstructor
public class TipoVentaServiceImpl implements TipoVentaService {

        private TipoVentaRepository tipoVentaRepository;

    @Override
    public TipoVentaDto createTipoVenta(TipoVentaDto tipoVentaDto) {
        TipoVenta tipoVenta = TipoVentaMapper.mapToTipoVenta(tipoVentaDto);
        return TipoVentaMapper.mapToTipoVentaDto(tipoVentaRepository.save(tipoVenta));
    }

    @Override
    public TipoVentaDto updateTipoVenta(Long id, TipoVentaDto tipoVentaDto) {
        TipoVenta tipoVenta = tipoVentaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_TIPO_VENTA + id) );
        tipoVenta.setTipo(tipoVentaDto.getTipo());
        tipoVenta.setStatus(tipoVentaDto.getStatus());
        tipoVenta.setCodigo(tipoVentaDto.getCodigo());
        tipoVenta.setDiesel(tipoVentaDto.getDiesel());
        tipoVenta.setRegular(tipoVentaDto.getRegular());
        tipoVenta.setPremiun(tipoVentaDto.getPremiun());
        return TipoVentaMapper.mapToTipoVentaDto(tipoVentaRepository.save(tipoVenta));
    }

    @Override
    public Page<TipoVentaDto> getAllTipoVentas(FilterDto filterDto,Pageable pageable) {
        Page<TipoVenta> tipoVentas = tipoVentaRepository.findByFilters(filterDto.getStatus(), filterDto.getId(), pageable);
        return tipoVentas.map(TipoVentaMapper::mapToTipoVentaDto);
    }
}
