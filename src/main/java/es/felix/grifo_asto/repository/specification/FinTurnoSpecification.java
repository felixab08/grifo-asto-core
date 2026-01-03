package es.felix.grifo_asto.repository.specification;

import es.felix.grifo_asto.dto.request.turno.FinTurnoFilterDto;
import es.felix.grifo_asto.entity.FinTurno;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinTurnoSpecification {

    public static Specification<FinTurno> withFilters(FinTurnoFilterDto filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getStartDate() != null) {
                Date start = Date.from(filter.getStartDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
                predicates.add(cb.greaterThanOrEqualTo(root.get("fechaEntrada"), start));
            }

            if (filter.getEndDate() != null) {
                Date end = Date.from(filter.getEndDate().atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant());
                predicates.add(cb.lessThanOrEqualTo(root.get("fechaEntrada"), end));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
