package com.fbfagostousa.domain.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Categoria {

    @Id
    private Long id;

    @Column
    private String nombre;
/*
    @ManyToMany
    private List<CaracteristicaDeprecated> caracteristicaDeprecateds;
    */

}
