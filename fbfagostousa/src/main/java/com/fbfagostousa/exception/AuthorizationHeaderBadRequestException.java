package com.fbfagostousa.exception;

public class AuthorizationHeaderBadRequestException extends Exception {

    public static final String DESCRIPTION= "Error de cabeceras incompletas!";

    public AuthorizationHeaderBadRequestException(){
        super(DESCRIPTION);
    }

    public AuthorizationHeaderBadRequestException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
