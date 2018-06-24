package com.fbfagostousa.service;

import com.fbfagostousa.domain.users.Role;
import com.fbfagostousa.domain.users.Usuario;
import com.fbfagostousa.repository.AutorizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AutorizacionService {

    @Autowired
    private AutorizacionRepository autorizacionRepository;

    //Si el usuario registrado no tiene un rol asignado, el rol por defecto es AUTHENTICATED
    public List<Role> findRoleByUsuario(Usuario usuario){
        List<Role> listaDeRoles=autorizacionRepository.findRoleByUsuario(usuario);
        if(listaDeRoles.isEmpty())
            listaDeRoles= Arrays.asList(Role.AUTHENTICATED);
        return listaDeRoles;
    }
}
