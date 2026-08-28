package es.felix.grifo_asto.repository.specification;

import es.felix.grifo_asto.dto.request.turno.FinTurnoFilterDto;
import es.felix.grifo_asto.entity.FinTurno;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class FinTurnoSpecification {

    public static Specification<FinTurno> withFilters(FinTurnoFilterDto filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getStartDate() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("fechaEntrada"), filter.getStartDate()));
            }

            if (filter.getEndDate() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("fechaEntrada"), filter.getEndDate()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
