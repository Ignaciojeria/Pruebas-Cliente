package com.fbfagostousa.service;

import com.fbfagostousa.domain.Categoria;
import com.fbfagostousa.domain.CategoriaRestoranId;
import com.fbfagostousa.exception.CategoriaIdNotFoundException;
import com.fbfagostousa.exception.RestoranIdNotFoundException;
import com.fbfagostousa.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RestController
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private RestoranService restoranService;

    public Categoria findById(Long id) throws CategoriaIdNotFoundException {
        Optional<Categoria> optional= categoriaRepository.findById(id);
        if(!optional.isPresent())
            throw new CategoriaIdNotFoundException("La categoria con el id: ".concat(id.toString()).concat(" no existe"));

        return optional.get();
    }



}
