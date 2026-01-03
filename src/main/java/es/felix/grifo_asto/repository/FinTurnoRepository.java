package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.FinTurno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinTurnoRepository extends JpaRepository<FinTurno, Long>, org.springframework.data.jpa.repository.JpaSpecificationExecutor<FinTurno> {

    List<FinTurno> findByPersona_IdPersona(Long idPersona, org.springframework.data.domain.Pageable pageable);
}
