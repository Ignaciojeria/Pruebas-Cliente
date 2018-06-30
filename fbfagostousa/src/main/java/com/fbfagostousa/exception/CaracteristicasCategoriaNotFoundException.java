package com.fbfagostousa.exception;

public class CaracteristicasCategoriaNotFoundException extends Exception {

    public static final String DESCRIPTION= "Categoria no encontrada, caracteristicas erroneas; ";

    public CaracteristicasCategoriaNotFoundException(){
        super(DESCRIPTION);
    }

    public CaracteristicasCategoriaNotFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }

}
