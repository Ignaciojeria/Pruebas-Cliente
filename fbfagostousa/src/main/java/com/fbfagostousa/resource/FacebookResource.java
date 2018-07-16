package com.fbfagostousa.resource;

import com.fbfagostousa.api.Api;
import com.fbfagostousa.domain.users.Usuario;
import com.fbfagostousa.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FacebookResource {

    @Autowired
    private FacebookService facebookService;

    /** Paso 1:
     * Abre una ventana emergente de Inicio de sesi�n y si mis credenciales son correctas
     * me redirecciona a "dominio:puerto/facebook"
     */
    @GetMapping(Api.LOGIN_FACEBOOK)
    public void createFacebookAuthorizationURL(HttpServletResponse response) throws IOException {
        response.sendRedirect(facebookService.createFacebookAuthorizationURL());
    }

    /** Paso 2:
     * Cuando me redireccione obtendr� un token correspondiente a mi cuenta de facebook
     * Con este token podr� obtener la id del usuario el correo, su foto, etc.
     * La redireccion es "localhost:8080/facebook" Esta est� permitida en la redirecci�n
     * del api de facebook developers
     */
    @GetMapping(Api.LOGIN_FACEBOOK_REDIRECT)
    public Usuario createFacebookAccessToken(@RequestParam("code") String code) throws AuthenticationException {
        return facebookService.createUserFromFacebookAccessToken(code);
    }

}
