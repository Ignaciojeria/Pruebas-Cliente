package com.fbfagostousa.exception;

public class AuthorizationHeaderBadRequestException extends Exception {

    public static final String DESCRIPTION= "Header: 'Authorization' de la solicitud http no encontrado, debes de albergar el token del usuario para poder procesar la solicitud";

    public AuthorizationHeaderBadRequestException(){
        super(DESCRIPTION);
    }

    public AuthorizationHeaderBadRequestException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
