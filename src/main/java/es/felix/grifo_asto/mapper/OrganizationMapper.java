package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.OrganizationDto;
import es.felix.grifo_asto.entity.Organization;

public class OrganizationMapper {
    public static OrganizationDto mapToorganizationMapperDto(Organization org) {
       OrganizationDto orgDto =  new OrganizationDto();
                orgDto.setIdOrganization(org.getIdOrganization());
                orgDto.setNombreOrganization(org.getNombreOrganization());
                orgDto.setStatus(org.getStatus());
                orgDto.setRuc(org.getRuc());
        return orgDto;
    }
    public static Organization mapToorganizationMapper(OrganizationDto orgDto) {
       Organization org = new Organization();
                org.setIdOrganization(orgDto.getIdOrganization());
                org.setNombreOrganization(orgDto.getNombreOrganization());
                org.setStatus(orgDto.getStatus());
                org.setRuc(orgDto.getRuc());
        return org;
    }
}
