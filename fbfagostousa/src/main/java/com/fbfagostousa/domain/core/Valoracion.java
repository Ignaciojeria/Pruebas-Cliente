package com.fbfagostousa.domain.core;

import com.fbfagostousa.domain.users.Usuario;

import javax.persistence.*;
import java.util.List;

@Entity
public class Valoracion {

    /** La valoracion se hace sobre la caracteristica de la categoria de un plato la a partir de lógica de negocio
     * podremos ver si la caracteroistica de la categoría de ese plato existe para poder registrar la valoración */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Plato plato;

    @ManyToOne
    private Caracteristica caracteristica;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private HistorialVotacion historialVotacion;

    @Column
    private Long valor;


    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

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
