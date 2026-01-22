package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.OrganizationDto;
import es.felix.grifo_asto.entity.Organization;

public class OrganizationMapper {
    public static OrganizationDto mapToorganizationMapperDto(Organization org) {
        return  new OrganizationDto(
                org.getIdOrganization(),
                org.getNombreOrganization(),
                org.getStatus(),
                org.getRuc()
        );
    }
    public static Organization mapToorganizationMapper(OrganizationDto orgDto) {
        return new Organization(
                orgDto.getIdOrganization(),
                orgDto.getNombreOrganization(),
                orgDto.getStatus(),
                orgDto.getRuc()
        );
    }
}
