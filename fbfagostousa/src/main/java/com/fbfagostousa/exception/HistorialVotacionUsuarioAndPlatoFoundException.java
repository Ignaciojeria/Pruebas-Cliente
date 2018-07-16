package com.fbfagostousa.exception;

public class HistorialVotacionUsuarioAndPlatoFoundException extends Exception {
    public static final String DESCRIPTION= "Has intentado votar 2 veces por la misma categoría";

    public HistorialVotacionUsuarioAndPlatoFoundException(){
        super(DESCRIPTION);
    }

    public HistorialVotacionUsuarioAndPlatoFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
