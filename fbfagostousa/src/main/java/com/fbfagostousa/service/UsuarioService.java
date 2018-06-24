package com.fbfagostousa.service;

import com.fbfagostousa.domain.users.Usuario;
import com.fbfagostousa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByValorToken(String valorToken){
        Optional<Usuario> usuarioOptional= this.usuarioRepository.findByValorToken(valorToken);

        if(!usuarioOptional.isPresent())
            throw new UsernameNotFoundException("Usuario no registrado");

        return usuarioOptional.get();
    }


}
