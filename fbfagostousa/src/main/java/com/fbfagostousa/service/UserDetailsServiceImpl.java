package com.fbfagostousa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.fbfagostousa.domain.users.Role;
import com.fbfagostousa.domain.users.Usuario;
import com.fbfagostousa.repository.AutorizacionRepository;
import com.fbfagostousa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl  implements UserDetailsService {

    //Utilizaremos el repositorio para buscar al usuario por su token
    @Autowired
    private UsuarioService usuarioService;

    //Si obtenemos al usuario, entonces, Buscaremos los roles a los que está asociado ese usuario
    @Autowired
    private AutorizacionService autorizacionService;

    //Si se hace autenticación por facebook o google el filtro debería ser el mismo!.
    //El login de facebook/google debería encargarse de persistir y retornar el toker correspondiente para
    //la autenticación!.

    //Este método lo utiliza spring para verificar si el usuario existe y verificar sus roles.
    @Override
    public UserDetails loadUserByUsername(final String valorToken) throws UsernameNotFoundException {

        Usuario usuario= this.usuarioService.findByValorToken(valorToken);

        List<Role> listaDeRoles= autorizacionService.findRoleByUsuario(usuario);

        return this.userBuilder(valorToken,new BCryptPasswordEncoder().encode(""),listaDeRoles);
    }

    //Este es el retorno de usuario que utiliza spring como referencia
    //(no persiste ni busca nada en la base de datos, es sólo un envolvente de nuestro filtro de seguridad que reconoce spring)
    private org.springframework.security.core.userdetails.User userBuilder(String mobile, String password, List<Role> roles) {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.roleName()));
        }
        return new org.springframework.security.core.userdetails.User(mobile, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
    }
}
