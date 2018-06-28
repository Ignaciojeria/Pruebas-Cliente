package com.fbfagostousa.domain.core;

import javax.persistence.*;
import java.util.List;

@Entity
public class Garzon {

    @Id
    private Long id;

    @Column
    private String nombre;

    @ManyToOne
    private Restoran restoran;

    public  Garzon(){}
}
