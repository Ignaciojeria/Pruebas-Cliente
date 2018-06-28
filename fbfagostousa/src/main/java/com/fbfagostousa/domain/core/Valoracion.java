package com.fbfagostousa.domain.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Valoracion {

    @Id
    private Long id;

    @Column
    private String nombre;

    @Column
    private Long puntaje;

    /*
    @ManyToOne
    private PlatoRestoranDeprecated platoRestoranDeprecated;
*/
}
