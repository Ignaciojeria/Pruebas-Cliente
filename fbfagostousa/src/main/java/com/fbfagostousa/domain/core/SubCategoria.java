package com.fbfagostousa.domain.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubCategoria {

    @Id
    private Long id;

    @Column
    private Long servicioDeCasa;

    @Column
    private Long ambienteDeCasa;

    @Column
    private Long saborDelPlato;

    @Column
    private Long presentacion;

    public String nombre;

    public SubCategoria(){}

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

    public Long getServicioDeCasa() {
        return servicioDeCasa;
    }

    public void setServicioDeCasa(Long servicioDeCasa) {
        this.servicioDeCasa = servicioDeCasa;
    }

    public Long getAmbienteDeCasa() {
        return ambienteDeCasa;
    }

    public void setAmbienteDeCasa(Long ambienteDeCasa) {
        this.ambienteDeCasa = ambienteDeCasa;
    }

    public Long getSaborDelPlato() {
        return saborDelPlato;
    }

    public void setSaborDelPlato(Long saborDelPlato) {
        this.saborDelPlato = saborDelPlato;
    }

    public Long getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Long presentacion) {
        this.presentacion = presentacion;
    }
}
