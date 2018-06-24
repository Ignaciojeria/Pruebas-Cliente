package com.fbfagostousa.config.security;

import com.fbfagostousa.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FiltroDeAutenticacion extends OncePerRequestFilter {

    //Esto es una inyección e inversión de dependencias ¿por qué es inversión de dependencias?
    //Por que se inyecta la interfaz UserDetailService y no la implementación concreta: UserDetailsServiceImpl
    //Intuyo que Spring debe de idetificar la sobreescritura del método loadUseByUserName sobreescrito en la implementacion concreta.
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    //Este es nuestro filtro personalizado por el cual van a pasar las solicitudes http que requieran autenticación
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
     String valorToken=request.getHeader("Authorization");
        if (valorToken != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            this.userDetailsServiceImpl.loadUserByUsername(valorToken);
        }

     filterChain.doFilter(request, response);
    }
}
