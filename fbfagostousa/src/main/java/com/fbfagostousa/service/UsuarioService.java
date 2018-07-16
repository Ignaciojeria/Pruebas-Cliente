package com.fbfagostousa.service;

import com.fbfagostousa.domain.users.Token;
import com.fbfagostousa.domain.users.Usuario;
import com.fbfagostousa.exception.AuthorizationHeaderBadRequestException;
import com.fbfagostousa.exception.UserRequestFieldBadRequestException;
import com.fbfagostousa.exception.UsuarioValorTokenNotFoundException;
import com.fbfagostousa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByValorToken(String valorToken) throws UsuarioValorTokenNotFoundException {
        Optional<Usuario> usuarioOptional= this.usuarioRepository.findByValorToken(valorToken);

        if(!usuarioOptional.isPresent())
            throw new UsuarioValorTokenNotFoundException("Sin autorizacion");

        return usuarioOptional.get();
    }

    //Registar un nuevo usuario:
    //Si el usuario existe, entonces se valida que tenga los campos nombre,telefono,estado,ciudad completados.
    //validar desde el front. Retornaré al usuario!.

    public Usuario findByEmail(String email){
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

    public Usuario IngresarConEmailPosicionadoEnElPlatoDeUnRestoranPorSuCodigoQr(String email, Long platoId, Long restoranId){
        String lowerCaseEmail=email.toLowerCase();
        Optional<Usuario> usuarioOptional= usuarioRepository.findByEmail(lowerCaseEmail);
        if(!usuarioOptional.isPresent()){
            Usuario usuario= new Usuario();
            usuario.setEmail(lowerCaseEmail);
         //   usuario.setToken(new Token(restoranId,platoId));
            return usuarioRepository.save(usuario);
        }

//        usuarioOptional.get().setToken(new Token(restoranId,platoId));
        return usuarioRepository.save(usuarioOptional.get());
    }

    public Usuario findByEmailInHeaders(HttpHeaders httpHeaders) throws AuthorizationHeaderBadRequestException {
        if(!httpHeaders.containsKey("email"))
            throw new AuthorizationHeaderBadRequestException("Debes envíar el email en las cabeceras!. key:'email' value:{$miCorreo@example.com}");

        String email=  httpHeaders.get("email").get(0);

        return this.findByEmail(email);
    }

    public Usuario poblarDatosDeNuevoUsuarioQueEntraIngresandoEmail(HttpHeaders httpHeaders,Usuario requestbody) throws AuthorizationHeaderBadRequestException, UsuarioValorTokenNotFoundException, UserRequestFieldBadRequestException {

        if(requestbody.getNombre()==null)
            throw new UserRequestFieldBadRequestException("Falta el atributo 'nombre' en el cuerpo de la solicitud HTTP ");
        if(requestbody.getTelefono()==null)
            throw new UserRequestFieldBadRequestException("Falta el atributo 'telefono' en el cuerpo de la solicitud HTTP ");
        if(requestbody.getPais()==null)
            throw new UserRequestFieldBadRequestException("Falta el atributo 'pais' en el cuerpo de la solicitud HTTP ");
        if(requestbody.getEstado()==null)
            throw new UserRequestFieldBadRequestException("Falta el atributo 'estado' en el cuerpo de la solicitud HTTP ");
        if(requestbody.getCiudad()==null)
            throw new UserRequestFieldBadRequestException("Falta el atributo 'ciudad' en el cuerpo de la solicitud HTTP ");

       Usuario usuario= this.findByEmailInHeaders(httpHeaders);

       usuario.setNombre(requestbody.getNombre());
       usuario.setTelefono(requestbody.getTelefono());
       usuario.setPais(requestbody.getPais());
       usuario.setEstado(requestbody.getEstado());
       usuario.setCiudad(requestbody.getCiudad());

        return usuarioRepository.save(usuario);
    }

}
