package com.fbfagostousa.service;


import com.fbfagostousa.api.Api;
import com.fbfagostousa.domain.users.Usuario;
import com.fbfagostousa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FacebookService {


    @Value("${spring.social.facebook.appId}")
    private String facebookAppId;
    @Value("${spring.social.facebook.appSecret}")
    private String facebookSecret;
    @Value("${domain}")
    private String domain;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    public String createFacebookAuthorizationURL(){
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri(domain.concat(Api.LOGIN_FACEBOOK_REDIRECT));
        params.setScope("public_profile,email,user_birthday");
        return oauthOperations.buildAuthorizeUrl(params);
    }

    public Usuario createUserFromFacebookAccessToken(String code) {
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code,domain.concat(Api.LOGIN_FACEBOOK_REDIRECT), null);
        return findUserByFacebookIdAndCreateIfUserNotExists(accessGrant.getAccessToken());
    }

    //Retorna un usuario de dominio por su facebookId
    public Usuario findUserByFacebookIdAndCreateIfUserNotExists(String accessToken) {
        Optional<Usuario> usuario;
        Facebook facebook = new FacebookTemplate(accessToken);
        String[] fields = {"id", "name","email","first_name","last_name"};
        //Usuario de facebook
        User facebookUserProfile = facebook.fetchObject("me", User.class, fields);
        //Usuario de dominio
        usuario=usuarioRepository.findByFacebookId(facebookUserProfile.getId());
        if (usuario.isPresent())
            return usuario.get();

        return   crearUsuarioSiNoExiste(facebookUserProfile);
    }

    //Si se registra un usuario por facebook y este no existe en la bdd entonces crea uno en nuetra bdd
    private Usuario crearUsuarioSiNoExiste(User facebookUserProfile) {

            Usuario usuario= usuarioService.findByEmail(facebookUserProfile.getEmail());

            usuario.setFacebookId(facebookUserProfile.getId());

            usuario.setNombre(facebookUserProfile.getFirstName());

            usuario.setTelefono(Api.GRAPH_API_URL
                    .concat(facebookUserProfile.getId()));


        return usuarioRepository.save(usuario);
    }

}
