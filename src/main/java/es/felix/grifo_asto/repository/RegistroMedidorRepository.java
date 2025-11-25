package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.RegistroMedidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroMedidorRepository extends JpaRepository<RegistroMedidor, Long> {
}
