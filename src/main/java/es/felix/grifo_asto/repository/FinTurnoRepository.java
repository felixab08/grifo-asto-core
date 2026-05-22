package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.FinTurno;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FinTurnoRepository extends JpaRepository<FinTurno, Long>, JpaSpecificationExecutor<FinTurno> {

    List<FinTurno> findByPersona_IdPersona(Long idPersona, Pageable pageable);
}
