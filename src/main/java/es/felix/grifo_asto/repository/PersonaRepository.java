package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
