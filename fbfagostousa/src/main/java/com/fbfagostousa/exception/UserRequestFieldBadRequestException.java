package com.fbfagostousa.exception;

public class UserRequestFieldBadRequestException extends Exception {

    public static final String DESCRIPTION= "El cuerpo de la solicitud HTTP esta incompleto";

    public UserRequestFieldBadRequestException(){
        super(DESCRIPTION);
    }

    public UserRequestFieldBadRequestException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
