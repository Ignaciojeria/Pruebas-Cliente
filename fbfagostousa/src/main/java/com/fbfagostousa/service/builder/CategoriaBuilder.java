package com.fbfagostousa.service.builder;

import com.fbfagostousa.domain.core.Categoria;

public class CategoriaBuilder {
    /**
     * El patrón builder facilita el armado de un objeto permitiento encadenar el procedimiento de
     * asignación de valores de un objeto complejo en un unico procedimiento y así facilitar las diferentes
     * representaciones de este sin caer en el anti-patron de los constructores telescopicos o sobre-carga de constructores.
     * Este patron sólo facilita la representación del objeto!!! No debería tener lógica de negocio asociada.
     */
    private Categoria categoria=new Categoria();

    private CategoriaBuilder(){}

    public static class Builder{

        CategoriaBuilder categoriaBuilder=new CategoriaBuilder();

        public Builder setNombre(String nombre){
            categoriaBuilder.categoria.setNombre(nombre);
            return this;
        }

        public Builder setDescripcion(String descripcion){
            categoriaBuilder.categoria.setDescripcion(descripcion);
            return this;
        }

        public Categoria build(){
            return categoriaBuilder.categoria;
        }


    }

}
