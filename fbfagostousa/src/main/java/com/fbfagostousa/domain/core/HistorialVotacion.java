package com.fbfagostousa.domain.core;

import com.fbfagostousa.domain.users.Usuario;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class HistorialVotacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Plato plato;

    @OneToOne
    private Usuario usuario;

    @Column
    private LocalDate fechaVotacion;

    @Column
    private LocalTime horaVotacion;

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaVotacion() {
        return fechaVotacion;
    }

    public void setFechaVotacion(LocalDate fechaVotacion) {
        this.fechaVotacion = fechaVotacion;
    }

    public LocalTime getHoraVotacion() {
        return horaVotacion;
    }

    public void setHoraVotacion(LocalTime horaVotacion) {
        this.horaVotacion = horaVotacion;
    }
}
