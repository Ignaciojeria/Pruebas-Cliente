package com.fbfagostousa.domain.core;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
public class Restoran  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "restoran")
    @JsonIgnore
    private List<PlatoRestoran> platos=new ArrayList<>();

    @ManyToMany
    private List<Categoria> categorias;

    @Column
    private String nombre;

    @OneToMany
    private List<Garzon> garzones;

    @Column
    private String descripcion;

    public Restoran(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<PlatoRestoran> getplatos() {
        return platos;
    }

    public void setplatos(List<PlatoRestoran> platos) {
        this.platos = platos;
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


}
