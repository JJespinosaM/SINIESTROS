package com.sura.siniestros.Servicios;

import com.sura.siniestros.Modelos.Siniestro;
import com.sura.siniestros.Repositorios.IRepositorioSiniestro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiniestroActualizarServicio {

    @Autowired
    private IRepositorioSiniestro repositorioSiniestro;

    public Siniestro actualizarSiniestro(long id, Siniestro datos) throws Exception {
        // Buscar el siniestro por id
        Siniestro siniestroExistente = repositorioSiniestro.findById(id).orElse(null);
        if (siniestroExistente == null) {
            throw new Exception("Siniestro no encontrado.");
        }

        // Validación de los campos
        if (datos.getFecha() == null || datos.getUbicacion() == null || datos.getTipo_siniestro() == null) {
            throw new Exception("Faltan datos obligatorios.");
        }

        // Actualizar los detalles del siniestro
        siniestroExistente.setFecha(datos.getFecha());
        siniestroExistente.setHora(datos.getHora());
        siniestroExistente.setUbicacion(datos.getUbicacion());
        siniestroExistente.setTipo_siniestro(datos.getTipo_siniestro());
        siniestroExistente.setPersonas_involucradas(datos.getPersonas_involucradas());
        siniestroExistente.setDanos_materiales(datos.getDanos_materiales());

        // Guardar el siniestro actualizado
        return repositorioSiniestro.save(siniestroExistente);
    }
}