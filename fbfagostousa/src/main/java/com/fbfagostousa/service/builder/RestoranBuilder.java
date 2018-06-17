package com.fbfagostousa.service.builder;

import com.fbfagostousa.domain.Categoria;
import com.fbfagostousa.domain.CategoriaRestoran;
import com.fbfagostousa.domain.Restoran;

import java.util.List;

public class RestoranBuilder {

    private Restoran restoran=new Restoran();

    private RestoranBuilder(){}

    public static class Builder{

        RestoranBuilder restoranBuilder=new RestoranBuilder();

        public Builder setNombre(String nombre){
            this.restoranBuilder.restoran.setNombre(nombre);
            return this;
        }

        public Builder setDescripcion(String descripcion){
            this.restoranBuilder.restoran.setDescripcion(descripcion);
            return this;
        }

        public Builder setCategorias(List<CategoriaRestoran> categorias){
            this.restoranBuilder.restoran.setCategorias(categorias);
            return this;
        }

        public Restoran build(){
            return restoranBuilder.restoran;
        }

    }
}
