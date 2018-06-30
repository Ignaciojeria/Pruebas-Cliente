package com.fbfagostousa.domain.core;

import com.fbfagostousa.domain.users.Usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class HistorialVotacion {

    @Id
    private Long id;

    @OneToOne
    private Plato plato;

    @OneToOne
    private Usuario usuario;

    @Column
    private LocalDate fechaVotacion;

    @Column
    private LocalTime horaVotacion;


}
