package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.OrganizationDto;
import es.felix.grifo_asto.dto.filter.FilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrganizationService {

    OrganizationDto createOrganization(OrganizationDto organizationDto);
    OrganizationDto updateOrganization(Long id, OrganizationDto organizationDto);
    Page<OrganizationDto> getAllOrganizations(FilterDto filter, Pageable pageable);
}
