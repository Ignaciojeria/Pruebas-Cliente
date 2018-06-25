package com.fbfagostousa.service;

import com.fbfagostousa.domain.users.Token;
import com.fbfagostousa.domain.users.Usuario;
import com.fbfagostousa.exception.AuthorizationHeaderBadRequestException;
import com.fbfagostousa.exception.UsuarioValorTokenNotFoundException;
import com.fbfagostousa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByValorToken(String valorToken) throws UsuarioValorTokenNotFoundException {
        Optional<Usuario> usuarioOptional= this.usuarioRepository.findByValorToken(valorToken);

        if(!usuarioOptional.isPresent())
            throw new UsuarioValorTokenNotFoundException("");

        return usuarioOptional.get();
    }

    //Registar un nuevo usuario:
    //Si el usuario existe, entonces se valida que tenga los campos nombre,telefono,estado,ciudad completados.
    //validar desde el front. Retornaré al usuario!.

    public Usuario ingresarConEmail(String email){
        String lowerCaseEmail=email.toLowerCase();
        Optional<Usuario> usuarioOptional= usuarioRepository.findByEmail(lowerCaseEmail);
        if(!usuarioOptional.isPresent()){
            Usuario usuario= new Usuario();
            usuario.setEmail(lowerCaseEmail);
            usuario.setToken(new Token());
            return usuarioRepository.save(usuario);
        }

        usuarioOptional.get().setToken(new Token());
    return usuarioRepository.save(usuarioOptional.get());
    }

    public Usuario poblarDatosDeNuevoUsuarioQueEntraIngresandoEmail(HttpHeaders httpHeaders) throws AuthorizationHeaderBadRequestException {

        if(!httpHeaders.containsKey("Authorization"))
            throw new AuthorizationHeaderBadRequestException("");

        String valorToken=  httpHeaders.get("Authorization").get(0);
        System.out.println(valorToken);
        return null;
    }

}
