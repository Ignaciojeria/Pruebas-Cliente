package com.fbfagostousa.exception;

public class UsuarioFieldsNotFoundException extends Exception {

    public static final String DESCRIPTION= "Datos personales del usuario a realizar la votación incompletos";

    public UsuarioFieldsNotFoundException(){
        super(DESCRIPTION);
    }

    public UsuarioFieldsNotFoundException(String detail){
        super(DESCRIPTION+ ", "+ detail);
    }

}
