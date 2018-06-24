package com.fbfagostousa.exception;

public class CategoriaIdAndRestoranIdNotFoundException extends Exception {

    public static final String DESCRIPTION= "Conjunto de claves foraneas que constituyen una clave primaria erroneo";

    public CategoriaIdAndRestoranIdNotFoundException(){
        super(DESCRIPTION);
    }

    public CategoriaIdAndRestoranIdNotFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
