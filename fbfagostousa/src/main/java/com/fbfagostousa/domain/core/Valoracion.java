package com.fbfagostousa.domain.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)//Ignora propiedades no enviadas en el requestBody de un POST
public class Valoracion implements Serializable{

    /** La valoracion se hace sobre la caracteristica de la categoria de un plato la a partir de lógica de negocio
     * podremos ver si la caracteroistica de la categoría de ese plato existe para poder registrar la valoración */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Plato plato;

    @ManyToOne
    private Caracteristica caracteristica;

    /*
    @ManyToOne
    private Usuario usuario;
    */

    @ManyToOne
    private HistorialVotacion historialVotacion;

    @Column
    private Long puntuacion;


    public Long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    /*
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/

    public HistorialVotacion getHistorialVotacion() {
        return historialVotacion;
    }

    public void setHistorialVotacion(HistorialVotacion historialVotacion) {
        this.historialVotacion = historialVotacion;
    }

    /*
    @ManyToOne
    private PlatoRestoranDeprecated platoRestoranDeprecated;
*/
}
