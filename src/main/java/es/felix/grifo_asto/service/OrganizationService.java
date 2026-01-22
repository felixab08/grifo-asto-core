package es.felix.grifo_asto.service;

import es.felix.grifo_asto.dto.OrganizationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrganizationService {

    OrganizationDto createOrganization(OrganizationDto organizationDto);
    OrganizationDto updateOrganization(Long id, OrganizationDto organizationDto);
    Page<OrganizationDto> getAllOrganizations(Pageable pageable);
}
