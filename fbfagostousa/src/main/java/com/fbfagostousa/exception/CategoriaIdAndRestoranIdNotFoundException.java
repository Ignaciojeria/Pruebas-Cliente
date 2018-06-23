package com.fbfagostousa.exception;

public class CategoriaIdAndRestoranIdNotFoundException extends Exception {

    public static final String DESCRIPTION= " id de categoria + id de restoran no encontrada.";

    public CategoriaIdAndRestoranIdNotFoundException(){
        super(DESCRIPTION);
    }

    public CategoriaIdAndRestoranIdNotFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
