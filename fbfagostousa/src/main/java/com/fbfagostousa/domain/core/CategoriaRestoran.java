package com.fbfagostousa.domain.core;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class CategoriaRestoran implements Serializable {

    @EmbeddedId
    private CategoriaRestoranId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("restoranId")
    private Restoran restoran;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("categoriaId")
    private Categoria categoria;

    @Column
    private Long puntaje;

    public  CategoriaRestoran(){}

    public CategoriaRestoran(Restoran restoran, Categoria categoria) {
        this.restoran = restoran;
        this.categoria = categoria;
        this.id = new CategoriaRestoranId(categoria.getId(), restoran.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CategoriaRestoran that = (CategoriaRestoran) o;
        return Objects.equals(categoria, that.categoria) &&
                Objects.equals(restoran, that.restoran);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria, restoran);
    }

    public CategoriaRestoranId getId() {
        return id;
    }

    public void setId(CategoriaRestoranId id) {
        this.id = id;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Long puntaje) {
        this.puntaje = puntaje;
    }
}
