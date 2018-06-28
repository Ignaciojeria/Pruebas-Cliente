package com.fbfagostousa.domain.core;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonInclude(Include.NON_NULL)
@NaturalIdCache
@Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Plato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    @ManyToOne
    private Categoria categoria;

    @OneToMany
    private List<Valoracion> valoraciones;

    @ManyToOne
    private Restoran restoran;

/*
    @OneToMany(
            mappedBy = "plato",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<PlatoRestoranDeprecated> restorans = new ArrayList<>();*/

    @Column
    private String descripcion;

    public Plato(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
/*
    public List<PlatoRestoranDeprecated> getRestorans() {
        return restorans;
    }

    public void setRestorans(List<PlatoRestoranDeprecated> restorans) {
        this.restorans = restorans;
    }*/
}
