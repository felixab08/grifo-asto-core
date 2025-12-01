package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.RegistroMedidor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroMedidorRepository extends JpaRepository<RegistroMedidor, Long> {
    List<RegistroMedidor> findByIdTurno_IdTurno(Long idTurno);
}
