package com.fbfagostousa.exception;

public class CategoriaRestoranIdNotFoundException extends Exception {

    public static final String DESCRIPTION= " El id de la categoria buscada no existe";

    public CategoriaRestoranIdNotFoundException(){
        super(DESCRIPTION);
    }

    public CategoriaRestoranIdNotFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
