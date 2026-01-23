package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.DetalleVenta;
import es.felix.grifo_asto.entity.TipoVenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    @Query("SELECT o FROM DetalleVenta o WHERE " +
            "(:id IS NULL OR o.tipoVenta.idTipoVenta = :id)")
    Page<DetalleVenta> findByFilters(@Param("id") Long id, Pageable pageable);
}
