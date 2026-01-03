package es.felix.grifo_asto.dto.request.turno;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinTurnoFilterDto {
    private LocalDate startDate;
    private LocalDate endDate;
}