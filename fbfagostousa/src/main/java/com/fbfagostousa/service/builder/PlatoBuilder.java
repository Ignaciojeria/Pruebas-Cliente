package com.fbfagostousa.service.builder;

import com.fbfagostousa.domain.core.Categoria;
import com.fbfagostousa.domain.core.Plato;
import com.fbfagostousa.domain.core.Restoran;

public class PlatoBuilder {
    /**
     * El patrón builder facilita el armado de un objeto permitiento encadenar el procedimiento de
     * asignación de valores de un objeto complejo en un unico procedimiento y así facilitar las diferentes
     * representaciones de este sin caer en el anti-patron de los constructores telescopicos o sobre-carga de constructores.
     * Este patron sólo facilita la representación del objeto!!! No debería tener lógica de negocio asociada.
     */
    private Plato plato =new Plato();

    private PlatoBuilder(){}

    public static class Builder{

        PlatoBuilder platoBuilder =new PlatoBuilder();

        public Builder setNombre(String nombre){
            platoBuilder.plato.setNombre(nombre);
            return this;
        }

        public Builder setCategoria(Categoria categoria){
            platoBuilder.plato.setCategoria(categoria);
            return this;
        }

        public Builder setRestoran(Restoran restoran){
            platoBuilder.plato.setRestoran(restoran);
            return this;
        }

        public Builder setDescripcion(String descripcion){
            platoBuilder.plato.setDescripcion(descripcion);
            return this;
        }

        public Plato build(){
            return platoBuilder.plato;
        }


    }

}
