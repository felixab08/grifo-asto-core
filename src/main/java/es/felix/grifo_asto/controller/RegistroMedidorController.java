package es.felix.grifo_asto.controller;

import es.felix.grifo_asto.controller.convert.GeneralResponse;
import es.felix.grifo_asto.dto.RegistroMedidorDto;
import es.felix.grifo_asto.service.RegistroMedidorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@RestController
@RequestMapping("api/registro-medidor")
public class RegistroMedidorController {
    final RegistroMedidorService  registroMedidorSrv;

    @PostMapping("/registrar")
    public ResponseEntity<RegistroMedidorDto> createRegistroMedidor(@RequestBody RegistroMedidorDto registroMedidorDto) {
        RegistroMedidorDto saved = registroMedidorSrv.crearRegistroMedidor(registroMedidorDto);
        return new  ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GeneralResponse> updateRegistroMedidor(@PathVariable("id") Long id, @RequestBody RegistroMedidorDto registroMedidorUpdateDto) {
        registroMedidorSrv.updateRegistroMedidor(id, registroMedidorUpdateDto);
        GeneralResponse respuestaGeneral = new GeneralResponse<>();

        try {
            respuestaGeneral.setCode(200);
            respuestaGeneral.setMessage("OK");
        } catch (Exception e) {
            respuestaGeneral.setCode(500);
            respuestaGeneral.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaGeneral);
        }
        return ResponseEntity.ok(respuestaGeneral);
    }


//    @GetMapping("/list")
//    public ResponseEntity<GeneralResponse<List<RegistroMedidorDto>>> getAllRegistroMedidor() {
//        List<RegistroMedidorDto> listaAll = registroMedidorSrv.getAllRegistroMedidores();
//        GeneralResponse<List<RegistroMedidorDto>> respuestaGeneral = new GeneralResponse<>();
//        try {
//            respuestaGeneral.setCode(200);
//            respuestaGeneral.setMessage("OK");
//            respuestaGeneral.setData(listaAll);
//        } catch (Exception e) {
//            respuestaGeneral.setCode(500);
//            respuestaGeneral.setMessage(e.getMessage());
//            respuestaGeneral.setData(null);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaGeneral);
//        }
//        return ResponseEntity.ok(respuestaGeneral);
//    }
}
