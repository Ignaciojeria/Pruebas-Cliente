package com.fbfagostousa.exception;

public class UsuarioValorTokenNotFoundException extends Exception {
    public static final String DESCRIPTION= "El token del usuario ha expirado o alguien más a utilizado su correo para iniciar una votación.";

    public UsuarioValorTokenNotFoundException(){
        super(DESCRIPTION);
    }

    public UsuarioValorTokenNotFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }
}
