package com.fbfagostousa.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CategoriaRestoranId implements Serializable {

    @Column
    private Long categoriaId;

    @Column
    private Long restoranId;

    @Column
    private Long puntaje;

    public CategoriaRestoranId(){}

    public CategoriaRestoranId(Long categoriaId, Long restoranId){
        this.categoriaId=categoriaId;
        this.restoranId=restoranId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CategoriaRestoranId that = (CategoriaRestoranId) o;
        return Objects.equals(categoriaId, that.categoriaId) &&
                Objects.equals(restoranId, that.restoranId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoriaId, restoranId);
    }

    public Long getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Long puntaje) {
        this.puntaje = puntaje;
    }
}
