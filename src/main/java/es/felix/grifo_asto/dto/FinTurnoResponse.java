package es.felix.grifo_asto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinTurnoResponse {
    
    private String messaje;
    private String code;
    private int status;
    private PersonaTurnosDto data;

    public FinTurnoResponse(String string, int i, PersonaTurnosDto of) {
        this.messaje = string;
        this.code = string;
        this.status = i;
        this.data = of;
    }
}
