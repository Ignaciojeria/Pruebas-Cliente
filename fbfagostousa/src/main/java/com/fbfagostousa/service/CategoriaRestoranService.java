package com.fbfagostousa.service;

import com.fbfagostousa.repository.CategoriaRestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaRestoranService {

    @Autowired
    private CategoriaRestoranRepository categoriaRestoranRepository;


}
