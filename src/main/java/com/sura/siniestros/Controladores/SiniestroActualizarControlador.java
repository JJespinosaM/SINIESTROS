package com.sura.siniestros.Controladores;

import com.sura.siniestros.Modelos.Siniestro;
import com.sura.siniestros.Servicios.SiniestroActualizarServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/siniestro")
public class SiniestroActualizarControlador {

    @Autowired
    private SiniestroActualizarServicio siniestroActualizarServicio;

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarSiniestro(@PathVariable long id, @RequestBody Siniestro datos) {
        try {
            // Delegar la actualización al servicio
            Siniestro siniestroActualizado = siniestroActualizarServicio.actualizarSiniestro(id, datos);
            return ResponseEntity.status(HttpStatus.OK).body(siniestroActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
