package es.felix.grifo_asto.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilterDto {
    private String searchTerm;
    private Boolean status;
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
}
