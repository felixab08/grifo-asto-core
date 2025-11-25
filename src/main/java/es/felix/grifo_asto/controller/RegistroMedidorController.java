package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.controller.convert.GeneralResponse;
import es.felix.grifo_asto.dto.PersonaDto;
import es.felix.grifo_asto.dto.RegistroMedidorDto;
import es.felix.grifo_asto.service.RegistroMedidorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/registro-medidor")
public class RegistroMedidorController {
    RegistroMedidorService  registroMedidorSrv;

    @PostMapping("/registrar")
    public ResponseEntity<RegistroMedidorDto> createRegistroMedidor(@RequestBody RegistroMedidorDto registroMedidorDto) {
        RegistroMedidorDto saved = registroMedidorSrv.crearRegistroMedidor(registroMedidorDto);
        return new  ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<GeneralResponse<List<RegistroMedidorDto>>> getAllRegistroMedidor() {
        List<RegistroMedidorDto> listaAll = registroMedidorSrv.getAllRegistroMedidores();
        GeneralResponse<List<RegistroMedidorDto>> respuestaGeneral = new GeneralResponse<>();
        try {
            respuestaGeneral.setCode(200);
            respuestaGeneral.setMessage("OK");
            respuestaGeneral.setData(listaAll);
        } catch (Exception e) {
            respuestaGeneral.setCode(500);
            respuestaGeneral.setMessage(e.getMessage());
            respuestaGeneral.setData(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaGeneral);
        }
        return ResponseEntity.ok(respuestaGeneral);
    }
}
