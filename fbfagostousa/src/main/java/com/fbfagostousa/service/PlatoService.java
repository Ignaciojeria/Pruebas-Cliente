package com.fbfagostousa.service;

import com.fbfagostousa.domain.core.Plato;
import com.fbfagostousa.exception.PlatoIdNotFoundException;
import com.fbfagostousa.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Service
@RestController
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private RestoranService restoranService;

    public Plato findById(Long id) throws PlatoIdNotFoundException {
        Optional<Plato> optional= platoRepository.findById(id);
        if(!optional.isPresent())
            throw new PlatoIdNotFoundException("La plato con el id: ".concat(id.toString()).concat(" no existe"));

        return optional.get();
    }



}
