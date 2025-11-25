package es.felix.grifo_asto.mapper;

import es.felix.grifo_asto.dto.MedicionDto;
import es.felix.grifo_asto.dto.MedicionRequestDto;
import es.felix.grifo_asto.entity.Medicion;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MedicionMapper {

    public static MedicionDto mapToMedicionDto(Medicion medicion) {
        log.info("Valor procesado: {}", medicion);
        return new MedicionDto(
                medicion.getIdMedicion(),
                medicion.getIdPersona(),
                medicion.getFechaMedicion(),
                medicion.getDiesel(),
                medicion.getRegular(),
                medicion.getPremiun()
        );
    }
    public static Medicion mapToMedicion(MedicionRequestDto medicionDto) {

        log.info("medicionDto>>>>",String.valueOf(medicionDto));

        return new Medicion(
                medicionDto.getIdpersona(),
                medicionDto.getFechaMedicion(),
                medicionDto.getDiesel(),
                medicionDto.getRegular(),
                medicionDto.getPremiun()
        );
    }
}
