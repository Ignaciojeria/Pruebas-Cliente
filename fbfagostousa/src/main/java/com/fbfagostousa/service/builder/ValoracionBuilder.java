package com.fbfagostousa.service.builder;

import com.fbfagostousa.domain.core.Caracteristica;
import com.fbfagostousa.domain.core.HistorialVotacion;
import com.fbfagostousa.domain.core.Plato;
import com.fbfagostousa.domain.core.Valoracion;

public class ValoracionBuilder {
    Valoracion valoracion = new Valoracion();

    public static class Builder{

        ValoracionBuilder valoracionBuilder=new ValoracionBuilder();

        public Builder setValor(Long valor){
            this.valoracionBuilder.valoracion.setValor(valor);
            return this;
        }

        public Builder setPlato(Plato plato){
            this.valoracionBuilder.valoracion.setPlato(plato);
            return this;
        }

        public Builder setHistorialVotacion(HistorialVotacion historialVotacion){
            this.valoracionBuilder.valoracion.setHistorialVotacion(historialVotacion);
            return this;
        }

        public Builder setCaracteristica(Caracteristica caracteristica){
            this.valoracionBuilder.valoracion.setCaracteristica(caracteristica);
            return this;
        }

        public Valoracion build(){
            return valoracionBuilder.valoracion;
        }


    }
}
