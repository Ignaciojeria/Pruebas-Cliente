package com.fbfagostousa.resource;

import com.fbfagostousa.domain.users.Usuario;
import com.fbfagostousa.exception.AuthorizationHeaderBadRequestException;
import com.fbfagostousa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login/{email}")
    public Usuario login(@PathVariable String email){
        return usuarioService.ingresarConEmail(email);
    }

    @PostMapping("/ingresarDatos")
    public Usuario poblarDatosDeNuevoUsuarioQueEntraIngresandoEmail(@RequestHeader HttpHeaders headers) throws AuthorizationHeaderBadRequestException {
        return usuarioService.poblarDatosDeNuevoUsuarioQueEntraIngresandoEmail(headers);
    }

}
