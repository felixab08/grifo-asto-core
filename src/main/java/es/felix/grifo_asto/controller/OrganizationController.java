package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.dto.OrganizationDto;
import es.felix.grifo_asto.dto.PersonaDto;
import es.felix.grifo_asto.dto.filter.FilterDto;
import es.felix.grifo_asto.service.OrganizationService;
import es.felix.grifo_asto.shared.PaginationResponse;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/organization")
public class OrganizationController {
    private OrganizationService organizationService;

    @PostMapping("/registrar")
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto saveOrganization =  organizationService.createOrganization(organizationDto);
        return new  ResponseEntity<>(saveOrganization, HttpStatus.CREATED);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<OrganizationDto> updateOrganization(@PathVariable("id") Long id, @RequestBody OrganizationDto upOrganizationDto) {
        OrganizationDto updateOrganization = organizationService.updateOrganization(id, upOrganizationDto);
        return new  ResponseEntity<>(updateOrganization, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<PaginationResponse<OrganizationDto>> getAllOrganizations(
            Pageable pageable,
            @RequestParam(required = false) Boolean status,
            @RequestParam(required = false) String searchTerm) {

        FilterDto filterDto = FilterDto.builder()
                .searchTerm(searchTerm)
                .status(status)
                .build();

        Page<OrganizationDto> page = organizationService.getAllOrganizations(filterDto, pageable);
        return ResponseEntity.ok(PaginationResponse.fromPage(page));
    }
}
