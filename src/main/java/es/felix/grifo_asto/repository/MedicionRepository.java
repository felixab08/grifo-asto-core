package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.Medicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicionRepository extends JpaRepository<Medicion,Long> {
}
