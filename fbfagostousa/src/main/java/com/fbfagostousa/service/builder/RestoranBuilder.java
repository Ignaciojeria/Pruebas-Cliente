package com.fbfagostousa.service.builder;

import com.fbfagostousa.domain.core.PlatoRestoranDeprecated;
import com.fbfagostousa.domain.core.Restoran;

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
/*
        public Builder setPlatos(List<PlatoRestoranDeprecated> platos){
            this.restoranBuilder.restoran.setplatos(platos);
            return this;
        }
*/
        public Restoran build(){
            return restoranBuilder.restoran;
        }

    }
}
