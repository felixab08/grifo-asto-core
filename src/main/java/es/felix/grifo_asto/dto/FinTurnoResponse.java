package es.felix.grifo_asto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinTurnoResponse {
    private String messaje;
    private int status;
    private List<PersonaTurnosDto> data;
}
