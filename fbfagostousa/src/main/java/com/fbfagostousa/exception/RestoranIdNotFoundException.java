package com.fbfagostousa.exception;

public class RestoranIdNotFoundException extends Exception {

    public static final String DESCRIPTION= " El id del restorante buscado no existe";

    public RestoranIdNotFoundException(){
        super(DESCRIPTION);
    }

    public RestoranIdNotFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
