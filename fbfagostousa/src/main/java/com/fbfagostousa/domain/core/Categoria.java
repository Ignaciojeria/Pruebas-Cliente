package com.fbfagostousa.domain.core;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descripion;

/*
    @CollectionTable(name = "categoria_caracteristicas", joinColumns = @JoinColumn(name = "categoria_id",referencedColumnName = "id"))
    @OrderColumn(name = "index_id")
    private List<Caracteristica> caracteristicas=new ArrayList<>();*/

    @ManyToMany
    private List<Caracteristica> caracteristicas;

/*
    @ManyToMany
    private List<CaracteristicaDeprecated> caracteristicaDeprecateds;
    */

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
