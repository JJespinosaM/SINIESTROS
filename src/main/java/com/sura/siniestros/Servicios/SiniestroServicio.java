package com.sura.siniestros.Servicios;

import com.sura.siniestros.Modelos.Siniestro;
import com.sura.siniestros.Repositorios.IRepositorioSiniestro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiniestroServicio {
    @Autowired
    IRepositorioSiniestro IRepositorioSiniestro;

    public Siniestro registrarSiniestro(Siniestro datosSiniestro) throws Exception{
        try{
            // guardar en la BBDD los datos del paciente
            return IRepositorioSiniestro.save(datosSiniestro);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Siniestro> buscarSiniestros() throws Exception{
        try{
            return IRepositorioSiniestro.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Siniestro buscarSiniestrosId(Siniestro datosSiniestro){
        return null;
    }
    // Método para buscar un siniestro por ID
    public Siniestro buscarSiniestroPorId(long id) {
        Optional<Siniestro> siniestro = IRepositorioSiniestro.findById(id);
        return siniestro.orElse(null);  // Devuelve null si no encuentra el siniestro
    }
}


