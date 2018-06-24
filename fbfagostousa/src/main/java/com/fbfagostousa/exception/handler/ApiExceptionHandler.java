package com.fbfagostousa.exception.handler;

import com.fbfagostousa.exception.CategoriaIdAndRestoranIdNotFoundException;
import com.fbfagostousa.exception.CategoriaIdNotFoundException;
import com.fbfagostousa.exception.CategoriaRestoranIdNotFoundException;
import com.fbfagostousa.exception.RestoranIdNotFoundException;
import com.fbfagostousa.exception.message.ErrorMessage;
import org.springframework.http.HttpStatus;
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
                         CategoriaIdAndRestoranIdNotFoundException.class})
    @ResponseBody
    public ErrorMessage notFountRequest(HttpServletRequest request, Exception exception){
        return  new ErrorMessage(exception,request.getRequestURI());
    }
}
