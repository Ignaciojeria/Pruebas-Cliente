package com.fbfagostousa.domain.core;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//@Entity
public class PlatoRestoranDeprecated implements Serializable {
/*
    @EmbeddedId
    private PlatoRestoranIdDeprecated id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("restoranId")
    private Restoran restoran;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("platoId")
    private Plato plato;*/

    /*
    @OneToOne
    private SubCategoriaDeprecated subCategoria;
*/

    /*
    @OneToMany
    private List<Valoracion> valoraciones;
*/

/*
    @Column
    private Long puntajeTotal;
    */

/*
    public PlatoRestoranDeprecated(){}

    public PlatoRestoranDeprecated(Restoran restoran, Plato plato) {
        this.restoran = restoran;
        this.plato = plato;
        this.id = new PlatoRestoranIdDeprecated(plato.getId(), restoran.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PlatoRestoranDeprecated that = (PlatoRestoranDeprecated) o;
        return Objects.equals(plato, that.plato) &&
                Objects.equals(restoran, that.restoran);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plato, restoran);
    }

    public PlatoRestoranIdDeprecated getId() {
        return id;
    }

    public void setId(PlatoRestoranIdDeprecated id) {
        this.id = id;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }*/
/*
    public Long getPuntaje() {
        return puntajeTotal;
    }

    public void setPuntaje(Long puntaje) {
        this.puntajeTotal = puntaje;
    }*/
}
