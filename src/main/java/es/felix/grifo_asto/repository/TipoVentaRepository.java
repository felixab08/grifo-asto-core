package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.TipoVenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TipoVentaRepository extends JpaRepository<TipoVenta, Long> {
    @Query("SELECT o FROM TipoVenta o WHERE " +
            "(:status IS NULL OR o.status = :status) AND " +
            "(:id IS NULL OR o.organization.idOrganization = :id)")
    Page<TipoVenta> findByFilters(@Param("status") Boolean status, @Param("id") Long id, Pageable pageable);
}
