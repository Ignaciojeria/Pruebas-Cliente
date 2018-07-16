package com.fbfagostousa.exception;

public class PlatoRestoranIdNotFoundException extends Exception {

    public static final String DESCRIPTION= " El id del plato buscado no existe";

    public PlatoRestoranIdNotFoundException(){
        super(DESCRIPTION);
    }

    public PlatoRestoranIdNotFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
