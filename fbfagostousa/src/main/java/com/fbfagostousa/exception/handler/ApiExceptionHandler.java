package com.fbfagostousa.exception.handler;

import com.fbfagostousa.exception.*;
import com.fbfagostousa.exception.message.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {

    //Acá se agrupa el conjunto de clases de excepciones que aplican al HttpStatus.NOT_FOUND.
    //Esas excepciones son desencadenadas por la lógica de negocio en el servicio
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({CategoriaIdNotFoundException.class,
                       RestoranIdNotFoundException.class,
                        CategoriaRestoranIdNotFoundException.class,
                         CategoriaIdAndRestoranIdNotFoundException.class,
                         UsernameNotFoundException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception){
        return  new ErrorMessage(exception,request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({AuthorizationHeaderBadRequestException.class,
                        UserRequestFieldBadRequestException.class})
    @ResponseBody
    public ErrorMessage badRequest(HttpServletRequest request, Exception exception){
        return  new ErrorMessage(exception,request.getRequestURI());
    }
}
