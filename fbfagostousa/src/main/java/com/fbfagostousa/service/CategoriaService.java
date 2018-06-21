package com.fbfagostousa.service;

import com.fbfagostousa.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void votar(){
        System.out.println("Has votado !!!");
    }


}
