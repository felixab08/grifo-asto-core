package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    @Query("SELECT o FROM Organization o WHERE " +
           "(:status IS NULL OR o.status = :status) AND " +
           "(:searchTerm IS NULL OR LOWER(o.nombreOrganization) LIKE LOWER(:searchTerm))  ORDER BY o.idOrganization DESC")
    Page<Organization> findByFilters(@Param("status") Boolean status, @Param("searchTerm") String searchTerm, Pageable pageable);
}
