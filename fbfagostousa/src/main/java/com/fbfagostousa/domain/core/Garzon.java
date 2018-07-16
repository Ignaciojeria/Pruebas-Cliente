package com.fbfagostousa.domain.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Garzon implements Serializable {

    @Id
    private Long id;

    @Column
    private String nombre;

    @ManyToOne
    private Restoran restoran;

    public  Garzon(){}
}
