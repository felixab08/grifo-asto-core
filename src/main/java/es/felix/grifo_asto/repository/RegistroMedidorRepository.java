package es.felix.grifo_asto.repository;

import es.felix.grifo_asto.entity.RegistroMedidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RegistroMedidorRepository extends JpaRepository<RegistroMedidor, Long> {
    List<RegistroMedidor> findByIdTurno_IdTurno(Long idTurno);
    
    @Query("SELECT rm FROM RegistroMedidor rm WHERE rm.idTurno.fechaEntrada BETWEEN :startDate AND :endDate")
    List<RegistroMedidor> findByIdTurno_FechaEntradaBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
