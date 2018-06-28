package com.fbfagostousa.exception;

public class PlatoIdNotFoundException extends Exception {

    public static final String DESCRIPTION= " El id del plato buscado no existe";

    public PlatoIdNotFoundException(){
        super(DESCRIPTION);
    }

    public PlatoIdNotFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
