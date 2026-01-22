package es.felix.grifo_asto.service.impl;

import es.felix.grifo_asto.dto.OrganizationDto;
import es.felix.grifo_asto.entity.Organization;
import es.felix.grifo_asto.exception.ResourceNotFoundException;
import es.felix.grifo_asto.mapper.OrganizationMapper;
import es.felix.grifo_asto.repository.OrganizationRepository;
import es.felix.grifo_asto.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import static es.felix.grifo_asto.config.Constants.NOT_FOUND_ORGANIZATION;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToorganizationMapper(organizationDto);
        Organization organizationSave =  organizationRepository.save(organization);
        return OrganizationMapper.mapToorganizationMapperDto(organizationSave);
    }

    @Override
    public OrganizationDto updateOrganization(Long id, OrganizationDto organizationDto) {
        Organization  organization = organizationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_ORGANIZATION + id) );
        organization.setNombreOrganization(organizationDto.getNombreOrganization());
        organization.setRuc(organizationDto.getRuc());
        organization.setStatus(organizationDto.getStatus());

        Organization  updateOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToorganizationMapperDto(updateOrganization);
    }

    @Override
    public Page<OrganizationDto> getAllOrganizations(Pageable pageable) {
        Page<Organization> orgnizaciones = organizationRepository.findAll(pageable);
        return orgnizaciones.map(OrganizationMapper::mapToorganizationMapperDto);
    }
}
