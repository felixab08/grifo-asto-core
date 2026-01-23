package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.DetalleVenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    @Query("SELECT o FROM DetalleVenta o WHERE " +
            "(:id IS NULL OR o.tipoVenta.idTipoVenta = :id) AND " +
            "(:startDate IS NULL OR CAST(o.fechaVenta AS DATE) >= :startDate) AND " +
            "(:endDate IS NULL OR CAST(o.fechaVenta AS DATE) <= :endDate)")
    Page<DetalleVenta> findByFilters(@Param("id") Long id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);
}
