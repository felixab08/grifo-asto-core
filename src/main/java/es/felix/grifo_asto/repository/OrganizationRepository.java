package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
