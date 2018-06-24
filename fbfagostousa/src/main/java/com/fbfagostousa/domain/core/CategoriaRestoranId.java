package com.fbfagostousa.domain.core;



import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CategoriaRestoranId implements Serializable {

    @Column
    private Long categoriaId;

    @Column
    private Long restoranId;

    //Ignora el atributo y lo considera como un transiente en la tabla embebbida , es decir, no se mapea a la tabla.
    // El atributo que enrealidad se mape es el puntaje de CategoriaRestoran y este transiente es una representacion,
    //valga la redundancia, transiente del puntaje de la tabla CategoriaRestoran
    @Transient
    private Long puntajeTransiente;

    public CategoriaRestoranId(){}

    public CategoriaRestoranId(Long categoriaId, Long restoranId){
        this.categoriaId=categoriaId;
        this.restoranId=restoranId;
    }

    public CategoriaRestoranId(Long categoriaId, Long restoranId,Long puntajeTransiente){
        this.categoriaId=categoriaId;
        this.restoranId=restoranId;
        this.puntajeTransiente=puntajeTransiente;
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



    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }

    public Long getPuntajeTransiente() {
        return puntajeTransiente;
    }

    public void setPuntajeTransiente(Long puntajeTransiente) {
        this.puntajeTransiente = puntajeTransiente;
    }



}
