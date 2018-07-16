package com.fbfagostousa.domain.core;



import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

//@Embeddable
public class PlatoRestoranIdDeprecated implements Serializable {
/*
    @Column
    private Long platoId;

    @Column
    private Long restoranId;

    //Ignora el atributo y lo considera como un transiente en la tabla embebbida , es decir, no se mapea a la tabla.
    // El atributo que enrealidad se mape es el puntaje de PlatoRestoranDeprecated y este transiente es una representacion,
    //valga la redundancia, transiente del puntaje de la tabla PlatoRestoranDeprecated
    @Transient
    private Long puntajeTotalTransiente;

    public PlatoRestoranIdDeprecated(){}

    public PlatoRestoranIdDeprecated(Long platoId, Long restoranId){
        this.platoId=platoId;
        this.restoranId=restoranId;
    }

    public PlatoRestoranIdDeprecated(Long platoId, Long restoranId, Long puntajeTotalTransiente){
        this.platoId=platoId;
        this.restoranId=restoranId;
        this.puntajeTotalTransiente=puntajeTotalTransiente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PlatoRestoranIdDeprecated that = (PlatoRestoranIdDeprecated) o;
        return Objects.equals(platoId, that.platoId) &&
                Objects.equals(restoranId, that.restoranId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platoId, restoranId);
    }



    public Long getplatoId() {
        return platoId;
    }

    public void setplatoId(Long platoId) {
        this.platoId = platoId;
    }

    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }

    public Long getPuntajeTotalTransiente() {
        return puntajeTotalTransiente;
    }

    public void setPuntajeTotalTransiente(Long puntajeTransiente) {
        this.puntajeTotalTransiente = puntajeTransiente;
    }*/

}
