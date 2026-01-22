package es.felix.grifo_asto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
    private Long idOrganization;
    private String nombreOrganization;
    private Boolean status;
    private String ruc;
}
