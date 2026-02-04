package es.felix.grifo_asto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteFinTurnoResponse {
    private int code;
    private List<Double> valores;
    private List<String> meses;
}
