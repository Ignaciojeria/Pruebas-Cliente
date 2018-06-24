package com.fbfagostousa.exception;

public class CategoriaIdNotFoundException extends Exception {

    public static final String DESCRIPTION= " El id de la categoria buscada no existe";

    public CategoriaIdNotFoundException(){
        super(DESCRIPTION);
    }

    public CategoriaIdNotFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
