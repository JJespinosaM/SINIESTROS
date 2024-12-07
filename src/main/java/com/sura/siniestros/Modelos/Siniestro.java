package com.sura.siniestros.Modelos;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "siniestros")
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;  // ID del accidente

    private Date fecha;  // Fecha del accidente

    private String hora;

    private String ubicacion;  // Ubicación del accidente (dirección o coordenadas)

    private String tipo_siniestro;  // Tipo de accidente (colisión, atropello, etc.)

    private int personas_involucradas;  // Número de personas involucradas en el accidente

    private String danos_materiales;  // Descripción de los daños materiales


    public Siniestro() {}

    // Constructor con parámetros
    public Siniestro(long id, Date fecha, String hora, String ubicacion, String tipo_siniestro,
                     int personas_involucradas, String danos_materiales) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
        this.tipo_siniestro = tipo_siniestro;
        this.personas_involucradas = personas_involucradas;
        this.danos_materiales = danos_materiales;
    }

    // Getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo_siniestro() {
        return tipo_siniestro;
    }

    public void setTipo_siniestro(String tipo_siniestro) {
        this.tipo_siniestro = tipo_siniestro;
    }

    public int getPersonas_involucradas() {
        return personas_involucradas;
    }

    public void setPersonas_involucradas(int personas_involucradas) {
        this.personas_involucradas = personas_involucradas;
    }

    public String getDanos_materiales() {
        return danos_materiales;
    }

    public void setDanos_materiales(String danos_materiales) {
        this.danos_materiales = danos_materiales;
    }

}

