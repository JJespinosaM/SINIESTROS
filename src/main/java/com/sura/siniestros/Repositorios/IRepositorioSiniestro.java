package com.sura.siniestros.Repositorios;

import com.sura.siniestros.Modelos.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioSiniestro extends JpaRepository<Siniestro, Long> {
}
