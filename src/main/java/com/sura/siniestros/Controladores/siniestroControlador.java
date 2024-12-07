package com.sura.siniestros.Controladores;

import com.sura.siniestros.Modelos.Siniestro;
import com.sura.siniestros.Servicios.SiniestroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/siniestro")
public class siniestroControlador {
    @Autowired
    SiniestroServicio siniestroServicio;
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Siniestro datos){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(siniestroServicio.registrarSiniestro(datos));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodo(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(siniestroServicio.buscarSiniestros());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    // Endpoint para actualizar los detalles del siniestro
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarSiniestro(@PathVariable long id, @RequestBody Siniestro datos) {
        try {
            // Verificar si el siniestro existe
            Siniestro siniestroExistente = siniestroServicio.buscarSiniestroPorId(id);
            if (siniestroExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Siniestro no encontrado.");
            }

            // Actualizar los detalles del siniestro
            siniestroExistente.setFecha(datos.getFecha());
            siniestroExistente.setHora(datos.getHora());
            siniestroExistente.setUbicacion(datos.getUbicacion());
            siniestroExistente.setTipo_siniestro(datos.getTipo_siniestro());
            siniestroExistente.setPersonas_involucradas(datos.getPersonas_involucradas());
            siniestroExistente.setDanos_materiales(datos.getDanos_materiales());

            // Guardar la actualización
            Siniestro siniestroActualizado = siniestroServicio.registrarSiniestro(siniestroExistente);
            return ResponseEntity.status(HttpStatus.OK).body(siniestroActualizado);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}


