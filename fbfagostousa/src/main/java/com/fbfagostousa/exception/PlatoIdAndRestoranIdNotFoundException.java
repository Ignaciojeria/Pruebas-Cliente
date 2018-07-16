package com.fbfagostousa.exception;

public class PlatoIdAndRestoranIdNotFoundException extends Exception {

    public static final String DESCRIPTION= "Conjunto de claves foraneas que constituyen una clave primaria erroneo";

    public PlatoIdAndRestoranIdNotFoundException(){
        super(DESCRIPTION);
    }

    public PlatoIdAndRestoranIdNotFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
