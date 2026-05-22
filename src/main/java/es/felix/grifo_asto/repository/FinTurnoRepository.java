package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.FinTurno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FinTurnoRepository extends JpaRepository<FinTurno, Long>, JpaSpecificationExecutor<FinTurno> {

    Page<FinTurno> findByPersona_IdPersona(Long idPersona, Pageable pageable);
}
